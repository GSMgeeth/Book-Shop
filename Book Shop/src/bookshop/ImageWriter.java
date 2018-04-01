package bookshop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

public class ImageWriter {

    private static final String USER_IMAGE_PATH = "C:\\Users\\GSM-PC\\Desktop\\ImageData\\UserImages";

    static{
        createIfNotExists();
    }
    
    public static void createIfNotExists() {
        File floders = new File(USER_IMAGE_PATH);
        boolean exst = floders.exists();
        if (!exst) {
            floders.mkdirs();
            System.out.println("Image Path create sucsusfull");
        }else{
            System.out.println("Already have image Path");
        }
    }
    
    public static void saveUserImage(BufferedImage  image,String name) throws IOException{
        try {
            File file = new File(USER_IMAGE_PATH+"\\"+name+".png");
            ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    

}
