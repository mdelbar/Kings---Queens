/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class Square extends JPanel {

    private boolean occupied, color;
    private int row, col;
    private Piece piece;

    public Square(boolean color, SquaresMouseListener sqML, int row, int col) {
        super();
        this.color = color;
        this.row = row;
        this.col = col;
        addMouseListener(sqML);
        occupied = false;
        piece = null;
        if(color)
            setBackground(ChessMaster.getLightColor());
        else
            setBackground(ChessMaster.getDarkColor());
        setLayout(new BorderLayout());
    }

    public void setPiece(Piece piece) {
        removeAll();
        occupied = true;
        this.piece = piece;
        add(piece, BorderLayout.CENTER);
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean o) {
        occupied = o;
    }

    public boolean getColor() {
        return color;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
