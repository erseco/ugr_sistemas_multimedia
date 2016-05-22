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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 * Esta clase contiene la configuración de la ventana principal en un momento determinado
 * cada vez que se crea un nuevo Shape se le asigna una copia del estado actual, que pasa a
 * ser independiente para cada instancia de Shape
 * 
 * @author Ernesto Serrano
 */
public class Config implements Cloneable
{

    public static Config GENERALCONFIG = new Config();

    private Tool selectedTool = Tool.POINT;
    private Color selectedColor = Color.BLACK;
    private Boolean fillColor = false;
    private Stroke stroke = new BasicStroke(1);
    private Boolean antialiasing = false;
    private Boolean alpha = false;

    /**
     * Clona el objeto
     *
     * @return the cloned Config instance
     */
    @Override
    public Config clone()
    {
        Config newconfig = new Config();
        newconfig.selectedTool = this.selectedTool;
        newconfig.selectedColor = this.selectedColor;
        newconfig.fillColor = this.fillColor;
        newconfig.stroke = this.stroke;
        newconfig.antialiasing = this.antialiasing;
        newconfig.alpha = this.alpha;

        return newconfig;
    }

    /**
     * Enumeracion con todas las herramientas que se pueden usar en una imagen
     */
    public enum Tool
    {
        HAND, // para mover
        POINT,
        LINE,
        RECTANGLE,
        ELLIPSE,
    }

    /**
     * Sets the current selected tool
     *
     * @param tool The tool to set as selected
     */
    public void setSelectedTool(Tool tool)
    {
        this.selectedTool = tool;
    }

    /**
     * Gets the current selected tool
     *
     * @return the selected tool
     */
    public Tool getSelectedTool()
    {
        return this.selectedTool;
    }

    /**
     * Establece el color actual
     * @param color el color a establecer
     */
    public void setSelectedColor(Color color)
    {
        this.selectedColor = color;
    }

    /**
     * Obtiene el color actual
     * @return un objeto Color
     */
    public Color getSelectedColor()
    {
        return this.selectedColor;
    }

    /**
     * Establece si se debe rellenar la figura
     * @param fill true si se debe rellenar
     */
    public void setFillColor(Boolean fill)
    {
        this.fillColor = fill;
    }

    /**
     * Obtiene si se debe rellenar la figura
     * @return true si se debe rellenar
     */
    public Boolean getFillColor()
    {
        return this.fillColor;
    }

    /**
     * Establece el grosor de la linea
     * @param pStroke grosor de la linea
     */
    public void setStroke(int pStroke)
    {
        this.stroke = new BasicStroke(pStroke);
    }

    /**
     * Obtiene el grosor de la linea
     * @return  grosor de la linea
     */
    public Stroke getStroke()
    {
        return this.stroke;
    }

    /**
     * Establece el suavizado
     * @param antialiasing  true si se debe suavizar
     */
    public void setAntialiasing(Boolean antialiasing)
    {
        this.antialiasing = antialiasing;
    }

    /**
     * Obtiene si esta activado el suavizado
     * @return true si se debe suavizar
     */
    public Boolean getAntialiasing()
    {
        return this.antialiasing;
    }

    /**
     * Activa el canal alfa
     * @param alpha true si esta activado
     */
    public void setAlpha(Boolean alpha)
    {
        this.alpha = alpha;
    }

    /**
     * Obtiene si está activado el canal alpha
     * @return true si esta activado
     */
    public Boolean getAlpha()
    {
        return this.alpha;
    }

}
