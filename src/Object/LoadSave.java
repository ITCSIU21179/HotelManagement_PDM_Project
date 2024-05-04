package Object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String lobby = "5451_ho_00_p_2048x1536.jpg";

    public static BufferedImage getImg(String filename){
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}
