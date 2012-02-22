/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Matthias
 */
public class Piece extends JLabel {
    
    private String pieceName;
    private boolean color;

    public Piece(String pieceName, boolean color) {
        super();
        this.pieceName = pieceName;
        this.color = color;
        if(color)
            setIcon(new ImageIcon(ImageLoader.getWhiteImage(pieceName)));
        else
            setIcon(new ImageIcon(ImageLoader.getBlackImage(pieceName)));
    }

    public boolean getColor() {
        return color;
    }

    public String getPieceName() {
        return pieceName;
    }

    
}
