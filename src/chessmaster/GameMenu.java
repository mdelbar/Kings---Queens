/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import controls.ExitAction;
import controls.LoadItem;
import controls.SaveItem;
import javax.swing.JMenu;

/**
 *
 * @author Matthias
 */
public class GameMenu extends JMenu {

    public GameMenu(Game game, GameFrame window) {
        super("Game");
        add(new SaveItem(game, window));
        add(new LoadItem(game, window));
        addSeparator();
        add(new ExitAction());
    }
}
