/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.esc.image;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductOp extends BinaryOp
{

    public ProductOp(BufferedImage img)
    {
        super(img);
    }

    @Override
    public int binaryOp(int v1, int v2)
    {
        int rdo = v1 * v2;
        return this.clampRange(rdo, 0, 255);
    }

}
