package sm.esc.image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

public class SepiaOp extends BufferedImageOpAdapter
{

    private final float[][] sepiaMatrix = new float[][]
    {
        {
            0.393f, 0.769f, 0.189f
        }, 
        {
            0.349f, 0.686f, 0.168f
        }, 
        {
            0.272f, 0.534f, 0.131f
        }
    };

    public SepiaOp()
    {
    }

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
            //Por hacer: efecto sepia

            float inputRed = pixel.sample[0];
            float inputGreen = pixel.sample[1];
            float inputBlue = pixel.sample[2];
            float outputRed = inputRed * this.sepiaMatrix[0][0] + inputGreen * this.sepiaMatrix[0][1] + inputBlue * this.sepiaMatrix[0][2];
            float outputGreen = inputRed * this.sepiaMatrix[1][0] + inputGreen * this.sepiaMatrix[1][1] + inputBlue * this.sepiaMatrix[1][2];
            float outputBlue = inputRed * this.sepiaMatrix[2][0] + inputGreen * this.sepiaMatrix[2][1] + inputBlue * this.sepiaMatrix[2][2];
            pixel.sample[0] = outputRed > 255.0f ? 255 : (int) outputRed;
            pixel.sample[1] = outputGreen > 255.0f ? 255 : (int) outputGreen;
            pixel.sample[2] = outputBlue > 255.0f ? 255 : (int) outputBlue;
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);

        }
        return dest;
    }
}
