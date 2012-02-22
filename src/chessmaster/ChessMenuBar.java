/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import javax.swing.JMenuBar;

/**
 *
 * @author Matthias
 */
public class ChessMenuBar extends JMenuBar {

    public ChessMenuBar(Game game, GameFrame window) {
        super();
        add(new GameMenu(game, window));
    }
}
