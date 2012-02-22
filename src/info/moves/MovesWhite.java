/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.moves;

import board.Square;
import chessmaster.ChessMaster;
import chessmaster.Piece;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class MovesWhite extends JPanel {

    public MovesWhite() {
        super();
        setBorder(BorderFactory.createTitledBorder("White"));
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
        // Update the screen
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
        // Update the screen
        updateUI();
    }
}
