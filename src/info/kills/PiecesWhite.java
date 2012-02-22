/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.kills;

import chessmaster.Piece;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class PiecesWhite extends JPanel {

    public PiecesWhite() {
        super();
        setBorder(BorderFactory.createTitledBorder("White"));
        setLayout(new GridLayout(0,3));
    }

    public void pieceKilled(Piece p) {
        add(p);
        updateUI();
    }
}
