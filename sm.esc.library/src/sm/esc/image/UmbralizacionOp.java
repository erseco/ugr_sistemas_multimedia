/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.esc.image;

import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Ernesto Serrano
 */
public class UmbralizacionOp extends BufferedImageOpAdapter
{

    private int umbral;

    public UmbralizacionOp(int umbral)
    {
        this.umbral = umbral;
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
