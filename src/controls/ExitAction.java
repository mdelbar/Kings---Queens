/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Matthias
 */
public class ExitAction extends AbstractAction {

    public ExitAction() {
        super("Exit");
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
