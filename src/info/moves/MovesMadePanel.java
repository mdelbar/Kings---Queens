/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.moves;

import board.Square;
import chessmaster.Piece;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class MovesMadePanel extends JPanel {

    private MovesWhite movesWhite;
    private MovesBlack movesBlack;

    public MovesMadePanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Moves Made"));
        setLayout(new GridLayout(1,2));
        movesWhite = new MovesWhite();
        movesBlack = new MovesBlack();
        add(movesWhite);
        add(movesBlack);
    }

    public void pieceMoved(Piece p, Square sq) {
        if(p.getColor()) {
            movesWhite.pieceMoved(p, sq);
        }
        else {
            movesBlack.pieceMoved(p, sq);
        }
    }

    public void pieceKilled(Piece p, Square oldSq, Square newSq) {
        if(p.getColor()) {
            movesWhite.pieceKilled(p, oldSq, newSq);
        }
        else {
            movesBlack.pieceKilled(p, oldSq, newSq);
        }
    }

    public MovesWhite getMovesWhite() {
        return movesWhite;
    }

    public MovesBlack getMovesBlack() {
        return movesBlack;
    }
}
