/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import chessmaster.Game;
import chessmaster.GameFrame;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Matthias
 */
public class LoadItem extends JMenuItem {

    public LoadItem(Game game, GameFrame window) {
        setAction(new LoadAction(game, window));
        setMnemonic(KeyEvent.VK_L);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK, true));
    }
}
