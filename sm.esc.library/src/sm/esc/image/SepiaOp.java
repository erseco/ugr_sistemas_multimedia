package sm.esc.image;


import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

public class SepiaOp extends BufferedImageOpAdapter
{ 
    public SepiaOp () {
    }
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    { 
        if (src == null) 
        {
            throw new NullPointerException("src image is null"); 
        }
        
        if (dest == null) 
        {
            dest = createCompatibleDestImage(src, null);
        }
        
        BufferedImagePixelIterator.PixelData pixel;
        
        for(BufferedImagePixelIterator it=new BufferedImagePixelIterator(src); it.hasNext();) 
        {
         pixel = it.next();
         //Por hacer: efecto sepia
        }
      return dest;
    } 
}