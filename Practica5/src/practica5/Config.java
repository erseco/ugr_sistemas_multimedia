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

import java.awt.Color;

/**
 * 
 * @author Ernesto Serrano <info@ernesto.es>
 */
public class Config {
    
    private static Tool selectedTool = Tool.POINT;
    private static Color selectedColor = Color.BLACK;
    private static Boolean fillColor = false;
    
    private static Boolean move = false;

    public enum Tool 
    {
        POINT,
        LINE,
        RECTANGLE,
        ELLIPSE,
    }
    
    public static void setSelectedTool(Tool tool)
    {
        selectedTool = tool;
    }
    
    public static Tool getSelectedTool()
    {
        return selectedTool;
    }
    
    
    public static void setSelectedColor(Color color)
    {
        selectedColor = color;
    }
    
    public static Color getSelectedColor()
    {
        return selectedColor;
    }
    
    public static void setFillColor(Boolean fill)
    {
        fillColor = fill;
    }
    
    public static Boolean getFillColor()
    {
        return fillColor;
    }

    public static void setMove(Boolean pMove)
    {
        move = pMove;
    }
    
    public static Boolean getMove()
    {
        return move;
    }
            
    
}
