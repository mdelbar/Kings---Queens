
package chessmaster;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Matthias Delbar
 */
public class ImageLoader {

    private static ArrayList<String> imgNames;

    public static ArrayList<Image> imgWhite, imgBlack;

    public ImageLoader() {
        // Init the names
        initImageNames();

        imgWhite = new ArrayList<Image>();
        imgBlack = new ArrayList<Image>();

        // Init the icons themselves
        for(String s : imgNames) {
            imgWhite.add(new ImageIcon(ImageLoader.class.getResource("/images/" + s + "_w.png")).getImage());
            imgBlack.add(new ImageIcon(ImageLoader.class.getResource("/images/" + s + "_zw.png")).getImage());
        }
    }

    private void initImageNames() {
        imgNames = new ArrayList<String>();
        imgNames.add("koning");
        imgNames.add("dame");
        imgNames.add("loper");
        imgNames.add("toren");
        imgNames.add("paard");
        imgNames.add("pion");
    }

    /**
     * Return the black version of name
     * @param name the name of the piece
     * @return the black-colored image that corresponds with the name
     */
    public static Image getBlackImage(String name) {
        return imgBlack.get(imgNames.indexOf(name));
    }

    /**
     * Return the white piece corresponding with name
     * @param name the name of the piece
     * @return the white-colored image that corresponds with the name
     */
    public static Image getWhiteImage(String name) {
        return imgWhite.get(imgNames.indexOf(name));
    }
}
