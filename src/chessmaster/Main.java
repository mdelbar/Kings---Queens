/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import javax.swing.UIManager;

/**
 *
 * @author Matthias
 */
public class Main/* extends JApplet*/ {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        
        new ImageLoader();
        new GameFrame();
    }

}