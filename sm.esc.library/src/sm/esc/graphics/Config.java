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
     * Clones a Config object
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
     * All the drawings tools
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
     * @param tool The tool to set as selected
     */
    public void setSelectedTool(Tool tool)
    {
        this.selectedTool = tool;
    }

    /**
     * Gets the current selected tool
     * @return the selected tool
     */
    public Tool getSelectedTool()
    {
        return this.selectedTool;
    }

    public void setSelectedColor(Color color)
    {
        this.selectedColor = color;
    }

    public Color getSelectedColor()
    {
        return this.selectedColor;
    }

    public void setFillColor(Boolean fill)
    {
        this.fillColor = fill;
    }

    public Boolean getFillColor()
    {
        return this.fillColor;
    }

    public void setStroke(int pStroke)
    {
        this.stroke = new BasicStroke(pStroke);
    }

    public Stroke getStroke()
    {
        return this.stroke;
    }
    
    public void setAntialiasing(Boolean antialiasing)
    {
        this.antialiasing = antialiasing;
    }

    public Boolean getAntialiasing()
    {
        return this.antialiasing;
    }
    
    public void setAlpha(Boolean alpha)
    {
        this.alpha = alpha;
    }

    public Boolean getAlpha()
    {
        return this.alpha;
    }

}
