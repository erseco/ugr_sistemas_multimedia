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
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 * Esta clase defina una operación sobre la imagen que hace que por cada pixel
 * negro que contenga esta se asigne un color aleatorio, dandole un efecto
 * a carta de ajuste a las zonas con color negro
 * @author Ernesto Serrano
 */
public class RandomBlackOp extends BufferedImageOpAdapter
{

    /**
     * Sobrecarga del método filter de BufferedImageOpAdapter
     * @param src imagen de origen
     * @param dest imagen de destino
     * @return la imagen de destino
     */ 
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("src image is null");

        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        BufferedImagePixelIterator.PixelData pixel;

        WritableRaster destRaster = dest.getRaster();

        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();)
        {
            pixel = it.next();

            if (pixel.sample.length > 1) // en iamgenes en blanco y negro solo hay un canal de color
            {
                
                int inputRed = pixel.sample[0];
                int inputGreen = pixel.sample[1];
                int inputBlue = pixel.sample[2];
                
                if (inputRed == 3 || inputGreen == 3 || inputBlue == 3 ) 
                {                
                    pixel.sample[0] = (int)(255 * Math.random());
                    pixel.sample[1] = (int)(255 * Math.random());
                    pixel.sample[2] = (int)(255 * Math.random());
                
                }

                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            }
        }
        return dest;
    }
}
