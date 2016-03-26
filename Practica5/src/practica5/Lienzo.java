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
package practica5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernesto
 */
public class Lienzo extends javax.swing.JPanel {

    private Point clickPoint;
    private Point startPoint;
    private Point endPoint;
    
    private List<Shape> shapes = new ArrayList();;
    private Shape selectedShape;
    
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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
        
        this.endPoint = evt.getPoint();
        
        //this.selectedShape.setFrameFromDiagonal(this.startPoint, evt.getPoint());
        
        
        int x, y, width, height; // Aqui almacenaremos las coordenadas
        
        width = Math.abs(this.startPoint.y - this.endPoint.y);
        height = Math.abs(this.startPoint.x - this.endPoint.x);
        
        ((Ellipse2D)this.selectedShape).setFrame(startPoint.x, startPoint.y, width, height);
        
        
        
        this.repaint();
        
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
        this.clickPoint = evt.getPoint();
        this.repaint();
               
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        this.startPoint = evt.getPoint();
        
        
        
        if ( Config.getMove() )
        {
        
            
            
        
            
            
           
        } else
        {
       
            
            //g.setColor(Config.getSelectedColor());
        
        
            int x, y, width, height; // Aqui almacenaremos las coordenadas


            switch (Config.getSelectedTool())
            {
                case POINT :

                    if (this.clickPoint == null) break;
                    
                    
                    this.selectedShape = new Line2D.Double(this.startPoint, this.endPoint);
                    
                    break;

                case LINE :

                    if (this.startPoint == null) break;
                    //g.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
                    //g.drawLine(this.startPoint.x, this.startPoint.y,this.endPoint.x-this.startPoint.x, this.endPoint.y - this.startPoint.y);

                    
                    this.selectedShape = new Line2D.Double(this.startPoint, this.endPoint);

                    break;

                case RECTANGLE :

                    if (this.startPoint == null) break;
//                    
                    width = Math.abs(this.startPoint.y - this.endPoint.y);
                    height = Math.abs(this.startPoint.x - this.endPoint.x);
//                    
                    this.selectedShape = new Rectangle2D.Double(startPoint.x, startPoint.y, width, height);
                
                    break;


                case ELLIPSE :
                    
                    width = Math.abs(this.startPoint.y - this.endPoint.y);
                    height = Math.abs(this.startPoint.x - this.endPoint.x);
                    
                    this.selectedShape = new Ellipse2D.Double(startPoint.x, startPoint.y, width, height);
                         
               
                
                  
                    break;

            }

        }
       
        this.shapes.add(this.selectedShape);
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        this. formMouseDragged(evt);  
        
//        int x, y, width, height; // Aqui almacenaremos las coordenadas
//        
//        width = Math.abs(this.startPoint.y - this.endPoint.y);
//        height = Math.abs(this.startPoint.x - this.endPoint.x);
//        
//        ((Ellipse2D)this.selectedShape).setFrame(startPoint.x, startPoint.y, width, height);
//                
        
//        if ( Config.getMove() )
//        {
//        
//            
//            
//        
//            
//            
//           
//        } else
//        {
//       
//            this.selectedShape.
//            
//            
//            //g.setColor(Config.getSelectedColor());
//        
//        
//            int x, y, width, height; // Aqui almacenaremos las coordenadas
//
//
//            switch (Config.getSelectedTool())
//            {
//                case POINT :
//
//                    if (this.clickPoint == null) break;
//                    //g.fillOval(this.clickPoint.x - 5, this.clickPoint.y - 5, 10, 10);
//
//                    Line2D line = new Line2D.Double(this.clickPoint, this.clickPoint);
//                    
//                
//                    
//                    this.shapes.add(line);
//
//                    //g.drawOval(this.startPoint.x, this.startPoint.y, 10, 10);
//
//                    break;
//
//                case LINE :
//
//                    if (this.startPoint == null) break;
//                    //g.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
//                    //g.drawLine(this.startPoint.x, this.startPoint.y,this.endPoint.x-this.startPoint.x, this.endPoint.y - this.startPoint.y);
//
//                    
//                    Line2D line2 = new Line2D.Double(this.startPoint, this.endPoint);
//
//                    
//                    this.shapes.add(line2);
//
//                    
//                    
//
//                    break;
//
//                case RECTANGLE :
//
//                    if (this.startPoint == null) break;
////                    
//                    width = Math.abs(this.startPoint.y - this.endPoint.y);
//                    height = Math.abs(this.startPoint.x - this.endPoint.x);
////                    
//                    Rectangle2D rectangle = new Rectangle2D.Double(startPoint.x, startPoint.y, width, height);
////                    
//                    this.shapes.add(rectangle);
////                  
//                    break;
//
//
//                case ELLIPSE :
//                    
//                    width = Math.abs(this.startPoint.y - this.endPoint.y);
//                    height = Math.abs(this.startPoint.x - this.endPoint.x);
//                    
//                    Ellipse2D ellipse = new Ellipse2D.Double(startPoint.x, startPoint.y, width, height);
//                    
//                    
//                    this.shapes.add(ellipse);
//
//                    break;
//
//            }
//
//        }
        
        
        
        
        this.repaint();
        
    }//GEN-LAST:event_formMouseReleased

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
     
        Graphics2D g2d=(Graphics2D)g;
        //Código usando g2d
        
        for(Shape shape: this.shapes)
            g2d.draw(shape);
        
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
