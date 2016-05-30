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
import java.awt.BasicStroke;
import java.awt.Color;
import sm.esc.base.Config;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sm.esc.graphics.Curve;
import sm.esc.graphics.Polygon;
import sm.esc.graphics.Polyline;
import sm.esc.graphics.Shape;

/**
 * Clase que extiene un JPanel para pintar sobre el un vector de formas
 *
 * @author Ernesto Serrano
 */
public class Canvas extends javax.swing.JPanel implements Cloneable
{

    /**
     * Vector de formas
     */
    protected List<sm.esc.graphics.Shape> shapes = new ArrayList();
    /**
     * Forma seleccionada
     */
    protected sm.esc.graphics.Shape selectedShape;
    /**
     * El clip (borde)
     */
    protected java.awt.Shape clip = null;

    private Point2D selectedShapePosition = new Point(0, 0);

    /**
     * Creates new form Canvas
     */
    public Canvas()
    {
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

        if (Config.GENERALCONFIG.getSelectedTool() == Config.Tool.HAND)
        {
            if (null != this.selectedShape)
                // Establecemos la posicion sumandole la posicion al hacer click
                this.selectedShape.setLocation(new Point((int) evt.getPoint().getX() + (int) this.selectedShapePosition.getX(), (int) evt.getPoint().getY() + (int) this.selectedShapePosition.getY()));

        } else if (this.selectedShape != null)
            this.selectedShape.resize(evt.getPoint());

        this.repaint();

    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        if (Config.GENERALCONFIG.getSelectedTool() == Config.Tool.HAND)
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
            try
            {
                // Agregamos una nueva figure
                switch (Config.GENERALCONFIG.getSelectedTool())
                {
                    case POINT:
                        this.selectedShape = new sm.esc.graphics.Point(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case LINE:
                        this.selectedShape = new sm.esc.graphics.Line(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case RECTANGLE:
                        this.selectedShape = new sm.esc.graphics.Rectangle(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case ROUNDRECTANGLE:
                        this.selectedShape = new sm.esc.graphics.RoundRectangle(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case ELLIPSE:
                        this.selectedShape = new sm.esc.graphics.Ellipse(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case ARC:
                        this.selectedShape = new sm.esc.graphics.Arc(Config.GENERALCONFIG.clone(), evt.getPoint());
                        break;
                    case POLYLINE:
                    {
                        if (this.selectedShape != null && this.selectedShape instanceof Polyline && ((Polyline) this.selectedShape).creating)
                            if (evt.getClickCount() == 2)
                                ((Polyline) this.selectedShape).onDoubleClick(evt.getPoint());
                            else
                                ((Polyline) this.selectedShape).onClick(evt.getPoint());
                        else
                            this.selectedShape = new sm.esc.graphics.Polyline(Config.GENERALCONFIG.clone(), evt.getPoint());

                    }
                    break;

                    case POLYGON:
                    {
                        if (this.selectedShape != null && this.selectedShape instanceof Polygon && ((Polygon) this.selectedShape).creating)
                            if (evt.getClickCount() == 2)
                                ((Polygon) this.selectedShape).onDoubleClick(evt.getPoint());
                            else
                                ((Polygon) this.selectedShape).onClick(evt.getPoint());
                        else
                            this.selectedShape = new sm.esc.graphics.Polygon(Config.GENERALCONFIG.clone(), evt.getPoint());

                    }
                    break;
                    case CURVE:
                    {
                        if (this.selectedShape != null && this.selectedShape instanceof Curve && ((Curve) this.selectedShape).creating)
                            ((Curve) this.selectedShape).onClick(evt.getPoint());
                        else
                            this.selectedShape = new sm.esc.graphics.Curve(Config.GENERALCONFIG.clone(), evt.getPoint());

                    }
                    break;

                }

                this.shapes.add(this.selectedShape);
            } catch (CloneNotSupportedException ex)
            {
                Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.paintShapeVector(g);
    }

    private void paintShapeVector(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        // Activamos el antialiasing GLOBAL
        if (Config.GENERALCONFIG.getAntialiasing())
            g2d.setRenderingHints(new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            ));

        // Activamos el canal alfa GLOBAL
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) Config.GENERALCONFIG.getAlpha() / 100));

        if (this.clip != null)
            g2d.clip(this.clip);

        // Pintamos las figuras del vector
        for (sm.esc.graphics.Shape s : this.shapes)
        {
            s.draw(g2d);
            if (s.equals(this.selectedShape))
            {
                g2d.setColor(Color.BLUE);
                float dash1[] =
                {
                    3.0f
                };
                g2d.setStroke(new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        3.0f, dash1, 0.0f));
                g2d.drawRect(s.getBounds().x - 1, s.getBounds().y - 1, s.getBounds().width + 2, s.getBounds().height + 2);
            }

        }
    }

    public Shape getSelectedShape()
    {
        return this.selectedShape;
    }

    private sm.esc.graphics.Shape getSelectedShape(Point2D p)
    {
        for (sm.esc.graphics.Shape s : this.shapes)
            if (s.contains(p))
                return s;

        return null;

    }

    protected void setClip(java.awt.Shape clip)
    {
        this.clip = clip;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
