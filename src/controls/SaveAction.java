/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import XML.ChessDocument;
import chessmaster.Game;
import chessmaster.GameFrame;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Matthias
 */
public class SaveAction extends AbstractAction {

    private Game game;
    private GameFrame window;

    public SaveAction(Game game, GameFrame window) {
        super("Save...");
        this.game = game;
        this.window = window;
    }

    public void actionPerformed(ActionEvent e) {
        ChessDocument myDoc = new ChessDocument(game);

        FileDialog dialog = new FileDialog(window, "Save Collection", FileDialog.SAVE);
        // NOODZAKELIJK! Anders krijgt de gebruiker geen popupvenster en volgt er een error
        dialog.setVisible(true);
        String filename = dialog.getDirectory() + dialog.getFile();

        // Een check voor filename.isEmpty() is niet nodig omdat FileDialog zelf al
        // die voorwaarde inlast
        if(filename != null) {
            // Code zoals gezien op twizz.ugent.be, met toevoeging van flush() en close()
            XMLOutputter outputter = new XMLOutputter();
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                outputter.output(myDoc, fos);
                fos.flush();
                fos.close();
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error while saving. Please try again.");
            }
        }
    }
}
