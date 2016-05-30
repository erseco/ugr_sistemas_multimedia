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

package sm.esc.graphics;

import java.awt.geom.Line2D;
import sm.esc.base.Config;

/**
 * Figura Punto, extiende una Linea ya que un punto es una linea con longitud 0
 * 
 * @author Ernesto Serrano
 */
public class Point extends Line 
{

    public Point(Config config, java.awt.Point startPoint)
    {
        super(config, startPoint);
    }
    
    @Override
    public void resize(java.awt.Point endPoint)
    {
        ((Line2D) this.internalShape).setLine(endPoint, endPoint);
    }

}
