/*
 *  Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package smm;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.image.BufferedImage;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 * Esta clase captura desde la webcam, usando sarxos:
 * http://webcam-capture.sarxos.pl/
 *
 * @author Ernesto Serrano
 */
public class InternalWindowWebCam extends JInternalFrame implements WebcamListener, UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener
{

    private static final long serialVersionUID = 1L;

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private WebcamPicker picker = null;

    public InternalWindowWebCam()
    {

        Webcam.addDiscoveryListener(this);

        setTitle("Java Webcam Capture POC");

        setLayout(new BorderLayout());
        setClosable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        picker = new WebcamPicker();
        picker.addItemListener(this);

        webcam = picker.getSelectedWebcam();

        if (webcam == null)
        {
            System.out.println("No webcams found...");
            System.exit(1);
        }

        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.addWebcamListener(InternalWindowWebCam.this);

        panel = new WebcamPanel(webcam, false);
        panel.setFPSDisplayed(true);

        add(picker, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        pack();
        setVisible(true);

        Thread t = new Thread()
        {

            @Override
            public void run()
            {
                panel.start();
            }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
        
        addInternalFrameListener(new javax.swing.event.InternalFrameListener()
        {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt)
            {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt)
            {
            }
        });
        
    }
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt)                                          
    {                                              
        webcam.close();
    }   
    @Override
    public void webcamOpen(WebcamEvent we)
    {
        System.out.println("webcam open");
    }

    @Override
    public void webcamClosed(WebcamEvent we)
    {
        System.out.println("webcam closed");
    }

    @Override
    public void webcamDisposed(WebcamEvent we)
    {
        System.out.println("webcam disposed");
    }

    @Override
    public void webcamImageObtained(WebcamEvent we)
    {
        // do nothing
    }


    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.err.println(String.format("Exception in thread %s", t.getName()));
        e.printStackTrace();
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getItem() != webcam)
            if (webcam != null)
            {

                panel.stop();

                remove(panel);

                webcam.removeWebcamListener(this);
                webcam.close();

                webcam = (Webcam) e.getItem();
                webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.addWebcamListener(this);

                System.out.println("selected " + webcam.getName());

                panel = new WebcamPanel(webcam, false);
                panel.setFPSDisplayed(true);

                add(panel, BorderLayout.CENTER);
                pack();

                Thread t = new Thread()
                {

                    @Override
                    public void run()
                    {
                        panel.start();
                    }
                };
                t.setName("example-stoper");
                t.setDaemon(true);
                t.setUncaughtExceptionHandler(this);
                t.start();
            }
    }

    @Override
    public void webcamFound(WebcamDiscoveryEvent event)
    {
        if (picker != null)
            picker.addItem(event.getWebcam());
    }

    @Override
    public void webcamGone(WebcamDiscoveryEvent event)
    {
        if (picker != null)
            picker.removeItem(event.getWebcam());
    }

    public BufferedImage getFrame()
    {
        return this.webcam.getImage();
    }

}
