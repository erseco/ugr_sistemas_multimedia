/*
 * Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sm.esc.ui;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import sm.esc.graphics.Config;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernesto
 */
public class Canvas extends javax.swing.JPanel {

    private List<sm.esc.graphics.Shape> shapes = new ArrayList();;
    private sm.esc.graphics.Shape selectedShape;
    protected java.awt.Shape clip = null;
    
    private Point2D selectedShapePosition = new Point(0, 0);
    
    /**
     * Creates new form Canvas
     */
    public Canvas() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
               
        if ( Config.GENERALCONFIG.getSelectedTool() == Config.Tool.HAND  )
        {
            if (null != this.selectedShape )
                // Establecemos la posicion sumandole la posicion al hacer click
                this.selectedShape.setLocation(new Point((int)evt.getPoint().getX() + (int)this.selectedShapePosition.getX(), (int)evt.getPoint().getY() + (int)this.selectedShapePosition.getY()));
                
            
            
        }
        else    
            this.selectedShape.resize(evt.getPoint());
        
       
        this.repaint();
        
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        if ( Config.GENERALCONFIG.getSelectedTool() == Config.Tool.HAND  )
        {

            
            // Obtenemos la forma seleccionada
            this.selectedShape = getSelectedShape(evt.getPoint());
            
            if (this.selectedShape != null)
            {
                // Guardamos la posicion de la figura seleccionada restandole donde estamos
                double x = this.selectedShape.getBounds().getX();
                double y = this.selectedShape.getBounds().getY();
                this.selectedShapePosition.setLocation(x - evt.getPoint().x, y - evt.getPoint().y);
            }           
            
        } else
        {
            // Agregamos una nueva firgura
            this.selectedShape = new sm.esc.graphics.Shape(Config.GENERALCONFIG.duplicate(), evt.getPoint());
            this.shapes.add(this.selectedShape);
            

      
        }
       
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this. formMouseDragged(evt); 
    }//GEN-LAST:event_formMouseReleased

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g); 
        this.paintShapeVector(g);
    }
    
    private void paintShapeVector(Graphics g)
    {        
        Graphics2D g2d = (Graphics2D)g;

        // Activamos el antialiasing GLOBAL
        if ( Config.GENERALCONFIG.getAntialiasing() )
            g2d.setRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            ));

        // Activamos el canal alfa GLOBAL
        if ( Config.GENERALCONFIG.getAlpha() )
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        
        if (this.clip != null) {
            g2d.clip(this.clip);
        }
        
        // Pintamos las figuras del vector
        for ( sm.esc.graphics.Shape s : this.shapes ) 
            s.draw(g2d);
           
    }
    
    
    private sm.esc.graphics.Shape getSelectedShape(Point2D p)
    {
        for ( sm.esc.graphics.Shape s : this.shapes)         
            if(s.contains(p)) 
                return s;
        
        return null;
    
    }
    
    public java.awt.Shape getClip() {
        return this.clip;
    }

    public void setClip(java.awt.Shape clip) {
        this.clip = clip;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
