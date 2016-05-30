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
import sm.image.BufferedImageSampleIterator;

/**
 * Operador de umbralizacion, genera una imagen binaria donde los píxeles que 
 * cumplen una propiedad se le asigna 1 y al resto 0
 * esta clase hereda de BufferedImageOpAdapter
 * 
 * @author Ernesto Serrano
 */
public class UmbralizacionOp extends BufferedImageOpAdapter
{

    private int umbral;

    /**
     * Constructor de la operacion
     * @param umbral el valor del umbral a detectar
     */
    public UmbralizacionOp(int umbral)
    {
        this.umbral = umbral;
    }

    /**
     * Sobrecarga del método filter de BufferedImageOpAdapter
     * @param src imagen de origen
     * @param dest imagen de destino
     * @return la imagen de destino
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {

        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = this.createCompatibleDestImage(src, null);
        }

        WritableRaster destRaster = dest.getRaster();
        BufferedImageSampleIterator it = new BufferedImageSampleIterator(src);
        while (it.hasNext()) {
            BufferedImageSampleIterator.SampleData sample = it.next();
            sample.value = sample.value < this.umbral ? 0 : 255;
            destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
        }
        return dest;

    }

}
