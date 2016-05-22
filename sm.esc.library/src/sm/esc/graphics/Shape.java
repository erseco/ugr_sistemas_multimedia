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
package sm.esc.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import static sm.esc.graphics.Config.Tool.LINE;
import static sm.esc.graphics.Config.Tool.POINT;

/**
 * Esta clase define una figura de nuestra aplicación, hereda de Shape y le agrea 
 * mas funcionalidad
 * 
 * @author Ernesto Serrano
 */
public class Shape implements java.awt.Shape, Cloneable
{

    private Config config;
    private java.awt.Shape internalShape;

    /**
     * Cosntructor de la clase
     * @param config una copia del objeto config actual
     * @param startPoint la posicion inicial
     */
    public Shape(Config config, Point startPoint)
    {
        this.config = config;

        switch (this.config.getSelectedTool())
        {
            case POINT:
            case LINE:

                this.internalShape = new Line2D.Double(startPoint, startPoint);
                break;

            case RECTANGLE:

                this.internalShape = new Rectangle(startPoint.x, startPoint.y, 0, 0);
                break;

            case ELLIPSE:

                this.internalShape = new Ellipse2D.Double(startPoint.x, startPoint.y, 0, 0);
                break;

        }

    }

    /**
     * Clone una imagen en otra
     * @return 
     */
    @Override
    public Shape clone()
    {
        Point startPoint = new Point(this.internalShape.getBounds().x, this.internalShape.getBounds().y);

        Shape shape = new Shape(this.config.clone(), startPoint);

        return shape;
    }

    /**
     * Establece la nueva posicion de la figura
     * @param newStartPoint 
     */
    public void setLocation(Point newStartPoint)
    {
        Point originalLocation = this.getLocation();

        int newx = (newStartPoint.x - originalLocation.x);
        int newy = (newStartPoint.y - originalLocation.y);

        switch (this.config.getSelectedTool())
        {
            case POINT:
            case LINE:

                Line2D line = ((Line2D) this.internalShape);
                double dx = newStartPoint.getX() - originalLocation.getX();
                double dy = newStartPoint.getY() - originalLocation.getY();

                ((Line2D) this.internalShape).setLine(line.getX1() + dx, line.getY1() + dy, line.getX2() + dx, line.getY2() + dy);

                break;

            case RECTANGLE:

                ((Rectangle) this.internalShape).setLocation(newStartPoint.x, newStartPoint.y);
                //((Rectangle)this.internalShape).setLocation(newx , newy);
                //((Rectangle)this.internalShape).setFrame(newx , newy, 100, 100);
                break;

            case ELLIPSE:

                Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
                ((Ellipse2D) this.internalShape).setFrame(newStartPoint.x, newStartPoint.y, ellipse.getWidth(), ellipse.getHeight());
                break;

        }

        //this.resize(startPoint, endPoint);
        //this.startPoint = p;
    }

    /**
     * Pinta la figura
     * @param g2d objeto Graphics2D
     */
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(this.config.getSelectedColor());
        g2d.setStroke(this.config.getStroke());

        if (this.config.getFillColor())
            g2d.fill(this);
        g2d.draw(this);

    }

    /**
     * Redimensiona la figura
     * @param endPoint 
     */
    public void resize(Point endPoint)
    {

        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();

        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;

        if (endPoint.x < startPoint.x)
            width = -1 * (startPoint.x - endPoint.x);

        if (endPoint.y < startPoint.y)
            height = startPoint.y - endPoint.y;

        switch (this.config.getSelectedTool())
        {
            case POINT:
                ((Line2D) this.internalShape).setLine(endPoint, endPoint);
                break;

            case LINE:

                ((Line2D) this.internalShape).setLine(startPoint, endPoint);
                break;

            case RECTANGLE:

                ((Rectangle) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
                break;

            case ELLIPSE:

                ((Ellipse2D) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
                break;

        }

    }

    /**
     * Comprueba si un determinado punto está cerca de la posición indicada
     * @param p punto
     * @return true si está cerca (a menos de 5 pixeles)
     */
    private boolean isNear(Point2D p)
    {
        return ((Line2D) this.internalShape).ptSegDist(p) <= 5.0;
    }

    /**
     * Obtiene las dimensiones de la figura
     * @return un objeto Rectangle
     */
    @Override
    public Rectangle getBounds()
    {
        return this.internalShape.getBounds();
    }

    /**
     * Obtiene las dimensiones de la figura
     * @return un objeto Rectangle2D
     */
    @Override
    public Rectangle2D getBounds2D()
    {
        return this.internalShape.getBounds2D();
    }

    /**
     * Comprueba si el objeto está en las cordenadas
     * @param x punto del eje x
     * @param y punto del eje y
     * @return true si está dentro
     */
    @Override
    public boolean contains(double x, double y)
    {
        return this.internalShape.contains(x, y);
    }

    /**
     * Comprueba si el objeto está en las cordenadas
     * @param p punto en forma de objeto Point2D
     * @return true si está dentro
     */
    @Override
    public boolean contains(Point2D p)
    {
        // Si es un punto o una línea hacemos uso del isNear()
        if ((this.config.getSelectedTool() == POINT || this.config.getSelectedTool() == LINE) && isNear(p))
            return true;

        return this.internalShape.contains(p);
    }

    /**
     * Dice si el punto está en una interseccion
     * @param x
     * @param y
     * @param w
     * @param h
     * @return 
     */
    @Override
    public boolean intersects(double x, double y, double w, double h)
    {
        return this.internalShape.intersects(x, y, w, h);
    }

    /**
     * Dice si el punto está en una interseccion
     * @param r
     * @return 
     */
    @Override
    public boolean intersects(Rectangle2D r)
    {
        return this.internalShape.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h)
    {
        return this.internalShape.contains(x, y, w, h);
    }

    @Override
    public boolean contains(Rectangle2D r)
    {
        return this.contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * OBtiene el objeto pathIterator
     * @param at
     * @return 
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at)
    {
        return this.internalShape.getPathIterator(at);
    }

    /**
     * Obtiene el objeto pathIterator
     * @param at
     * @param flatness
     * @return 
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness)
    {
        return this.internalShape.getPathIterator(at, flatness);
    }

    /**
     * Obtiene la posición de la figura en el lienzo
     * @return un objeto Point con la posicion
     */
    private Point getLocation()
    {
        switch (this.config.getSelectedTool())
        {
            case POINT:
            case LINE:

                Line2D line = ((Line2D) this.internalShape);
                return new Point((int) line.getX1(), (int) line.getY1());

            case RECTANGLE:

                return ((Rectangle) this.internalShape).getLocation();

            case ELLIPSE:

                Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
                return new Point((int) ellipse.getX(), (int) ellipse.getY());
        }

        return null;

    }

}
