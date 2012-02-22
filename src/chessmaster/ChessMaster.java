/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author Matthias
 */
public class ChessMaster {

    public static final char[] ROWS = {'8','7','6','5','4','3','2','1'};
    public static char[] COLS = {'a','b','c','d','e','f','g','h'};
    public static final HashMap<String, String> ABBREVIATIONS =
        new HashMap<String, String>()
        {
            {
                put("toren","R");
                put("paard","N");
                put("loper","B");
                put("koning","K");
                put("dame","Q");
            }
        };

    public static boolean player = true;
    public static int turn = 1;

    

    public ChessMaster() {
        
    }

    public static boolean getPlayer() {
        return player;
    }
    public static void moveMade() {
        player = !player;
    }
    

    /*
     * Colors
     */
    public static Color getLightColor() {
        return new Color(200,200,200);
    }
    public static Color getDarkColor() {
        return new Color(125,125,125);
    }
    public static Color getHoverColor() {
        return new Color(150,150,150);
    }
    public static Color getSelectedSquareColor() {
        return new Color(255,255,145);
    }
}
