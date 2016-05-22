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
package sm.esc.image;

/**
 * En esta enumeración definimos los KernelTypes definidos en sm.image para facilitar 
 * su utilización, ya que son valores enteros
 * 
 * @author Ernesto Serrano
 */
public enum KernelTypes {
    MEDIA(0),
    BINOMIAL(1),
    ENFOQUE(2),
    RELIEVE(3),
    LAPLACIANA(4),
    SOBELX(5),
    SOBELY(6);
    
    public int value;
 
    private KernelTypes(int value) 
    {
        this.value = value;
    }
    
}
