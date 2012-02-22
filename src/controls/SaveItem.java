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
public class SaveItem extends JMenuItem {

    public SaveItem(Game game, GameFrame window) {
        setAction(new SaveAction(game, window));
        setMnemonic(KeyEvent.VK_S);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK, true));
    }
}
