/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controls;

import XML.ChessXMLReader;
import chessmaster.Game;
import chessmaster.GameFrame;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import threads.NewGameRunnable;

/**
 *
 * @author Matthias
 */
public class LoadAction extends AbstractAction {

    private Game game;
    private GameFrame window;

    public LoadAction(Game game, GameFrame window) {
        super("Load...");
        this.game = game;
        this.window = window;
    }

    public void actionPerformed(ActionEvent e) {
        FileDialog dialog = new FileDialog(window, "Open Collection", FileDialog.LOAD);
        // NOODZAKELIJK! Anders krijgt de gebruiker geen dialoogvenster en is er een error
        dialog.setVisible(true);
        String filename = dialog.getDirectory() + dialog.getFile();
        if(filename != null) { // fileName == null betektent dat de gebruiker Cancel klikte
            try {
                // Zoals gezien in het boek, p. 80.
                Document doc = new SAXBuilder().build(new File(filename));
                ChessXMLReader reader = new ChessXMLReader(doc);
                new Thread(new NewGameRunnable(reader)).start();
            } catch (JDOMException ex) {
                JOptionPane.showMessageDialog(null, "Error while loading file. Please try again");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error while loading file. Please try again");
            }
        }
    }
}
