/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.kills;

import chessmaster.Piece;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Matthias
 */
public class PiecesTakenPanel extends JPanel {

    private PiecesWhite piecesWhite;
    private PiecesBlack piecesBlack;

    public PiecesTakenPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Pieces Taken"));
        setLayout(new GridLayout(2,1));
        piecesWhite = new PiecesWhite();
        piecesBlack = new PiecesBlack();
        add(new JScrollPane(piecesWhite));
        add(new JScrollPane(piecesBlack));
    }

    public void pieceKilled(Piece p) {
        if(p.getColor())
            piecesWhite.pieceKilled(p);
        else
            piecesBlack.pieceKilled(p);
    }

    public PiecesWhite getPiecesWhite() {
        return piecesWhite;
    }

    public PiecesBlack getPiecesBlack() {
        return piecesBlack;
    }
}
