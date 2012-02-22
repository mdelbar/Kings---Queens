/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.moves;

import board.Square;
import chessmaster.Piece;
import chessmaster.ChessMaster;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class MovesBlack extends JPanel {

    public MovesBlack() {
        super();
        setBorder(BorderFactory.createTitledBorder("Black"));
        setLayout(new GridLayout(0,1));
    }

    public void pieceMoved(Piece p, Square sq) {
        // Add the move
        String name = p.getPieceName();
        if(name.equals("pion")) {
            add(new JLabel(""
                + ChessMaster.COLS[sq.getCol()]
                + ChessMaster.ROWS[sq.getRow()]));
        }
        else {
        add(new JLabel(ChessMaster.ABBREVIATIONS.get(name)
                + ChessMaster.COLS[sq.getCol()]
                + ChessMaster.ROWS[sq.getRow()]));
        }
        // Do updates
        ChessMaster.turn++;
        updateUI();
    }

    public void pieceKilled(Piece p, Square oldSq, Square newSq) {
        // Add the move
        String name = p.getPieceName();
        if(name.equals("pion")) {
            add(new JLabel(""
                + ChessMaster.COLS[oldSq.getCol()]
                + "x"
                + ChessMaster.COLS[newSq.getCol()]
                + ChessMaster.ROWS[newSq.getRow()]));
        }
        else {
        add(new JLabel(ChessMaster.ABBREVIATIONS.get(name)
                + "x"
                + ChessMaster.COLS[newSq.getCol()]
                + ChessMaster.ROWS[newSq.getRow()]));
        }
        // Do updates
        ChessMaster.turn++;
        updateUI();
    }
}
