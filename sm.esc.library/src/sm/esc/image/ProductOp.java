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

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 * Operación binaria de multiplicación, es útil para enfatizar bordes, esta clase
 * extiende la clase base BinaryOp
 * @author Ernesto Serrano
 */
public class ProductOp extends BinaryOp
{
    
    /**
     * Constructor del operador
     * @param img la imagen sobre la que se va a realizar la operacion
     */
    public ProductOp(BufferedImage img)
    {
        super(img);
    }

    /**
     * Sobrecarga de la función binaryOp, en este caso lo que va a hacer es multiplar 
     * el valor de color de dos imagenes, y truncarlo a un maximo de 255
     * @param v1 el valor de un pixel de la imagen 1
     * @param v2 el valor de un pixel del a imagen 2
     * @return El resultado de la multiplicacion
     */
    @Override
    public int binaryOp(int v1, int v2)
    {
        int rdo = v1 * v2;
        if(rdo<=0) rdo=0;
        else if(rdo>=255) rdo=255;
        return rdo;
    }

}
