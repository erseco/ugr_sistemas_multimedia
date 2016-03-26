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

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
*
* @author Ernesto Serrano <info@ernesto.es>
*/
public class CanvasImage extends Canvas {

    private BufferedImage img;
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
    public BufferedImage getImage(){
        return img; 
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null) 
            g.drawImage(img,0,0,this);
    }
    
    
}
