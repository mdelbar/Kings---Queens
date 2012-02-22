/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info;

import board.Square;
import chessmaster.Piece;
import info.kills.PiecesTakenPanel;
import info.moves.MovesMadePanel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Matthias
 */
public class InfoPanel extends JPanel {

    private MovesMadePanel movesMade;
    private PiecesTakenPanel piecesTaken;

    public InfoPanel() {
        super();
        setLayout(new GridLayout(1,2));
        movesMade = new MovesMadePanel();
        piecesTaken = new PiecesTakenPanel();
        add(new JScrollPane(movesMade));
        add(piecesTaken);
    }

    public InfoPanel(MovesMadePanel movesMade, PiecesTakenPanel piecesTaken) {
        super();
        setLayout(new GridLayout(1,2));
        this.movesMade = movesMade;
        this.piecesTaken = piecesTaken;
        add(new JScrollPane(this.movesMade));
        add(this.piecesTaken);
    }

    public void pieceMoved(Piece p, Square sq) {
        movesMade.pieceMoved(p, sq);
    }

    public void pieceKilled(Piece p, Square oldSq, Square newSq) {
        piecesTaken.pieceKilled(newSq.getPiece());
        movesMade.pieceKilled(p, oldSq, newSq);
    }

    public MovesMadePanel getMovesMade() {
        return movesMade;
    }

    public PiecesTakenPanel getPiecesTaken() {
        return piecesTaken;
    }
}
