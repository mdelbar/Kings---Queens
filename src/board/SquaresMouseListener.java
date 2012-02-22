/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthias
 */
public class SquaresMouseListener implements MouseListener {

    private Board board;
    private int mouseDownRow, mouseDownCol;

    public SquaresMouseListener(Board board) {
        this.board = board;
    }
   
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        Square sq = (Square) e.getSource();
        mouseDownRow = sq.getRow();
        mouseDownCol = sq.getCol();
    }

    public void mouseReleased(MouseEvent e) {
        Square sq = (Square) e.getSource();
        boolean player = ChessMaster.getPlayer();
        if(mouseDownRow == sq.getRow() && mouseDownCol == sq.getCol()) {

            if(!board.isSelected()) {
                if(sq.isOccupied()) {
                    if(sq.getPiece().getColor() == player)
                        board.select(sq);
                    else {
                        if(player) {
                            JOptionPane.showMessageDialog(null, "It's White's turn to move!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "It's Black's turn to move!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else
                    board.deselect();
            }
            else {
                if(sq.isOccupied()) {
                    if(board.isSquareSelected(sq)) {
                        board.deselect();
                    }
                    else {
                        if(sq.getPiece().getColor() == player) {
                            board.select(sq);
                        }
                        else {
                            board.tryKill(sq);
                        }
                    }
                }
                else {
                    board.tryMove(sq);
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
        Square sq = (Square) e.getSource();
        if(!board.isSquareSelected(sq))
            sq.setBackground(ChessMaster.getHoverColor());
    }

    public void mouseExited(MouseEvent e) {
        Square sq = (Square) e.getSource();
        if(!board.isSquareSelected(sq)) {
            if(sq.getColor())
                sq.setBackground(ChessMaster.getLightColor());
            else
                sq.setBackground(ChessMaster.getDarkColor());
        }
    }
}
