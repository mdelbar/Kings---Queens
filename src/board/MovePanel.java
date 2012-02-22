/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.Piece;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class MovePanel extends JPanel {

    protected Square selSq;
    protected int selRow, selCol;
    protected Square[][] field;

    public MovePanel() {
        super();
    }

    public boolean checkMove(Piece p, Square sq) {
        String name = p.getPieceName();
        int sqRow = sq.getRow();
        int sqCol = sq.getCol();

        if(name.equals("pion")) {
            return checkMovePawn(p, sq, sqRow, sqCol);
        }
        else if(name.equals("toren")) {
            return checkMoveRook(p, sq, sqRow, sqCol);
        }
        else if(name.equals("paard")) {
            return checkMoveKnight(p, sq, sqRow, sqCol);
        }
        else if(name.equals("loper")) {
            return checkMoveBishop(p, sq, sqRow, sqCol);
        }
        else if(name.equals("dame")) {
            return checkMoveQueen(p, sq, sqRow, sqCol);
        }
        else if(name.equals("koning")) {
            return checkMoveKing(p, sq, sqRow, sqCol);
        }
        else
            return false;
    }

    public boolean checkMovePawn(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        if(p.getColor()) {
            if(selRow == 6) {
                if(sqCol == selCol) {
                    if(sqRow == selRow - 1)
                        return true;
                    else if(sqRow == selRow - 2 && !field[selRow-1][selCol].isOccupied())
                        return true;
                }
            }
            else {
                if(sqCol == selCol && sqRow == selRow - 1) {
                    return true;
                }
            }
        }
        else {
            if(selRow == 1) {
                if(sqCol == selCol) {
                    if(sqRow == selRow + 1)
                        return true;
                    else if(sqRow == selRow + 2 && !field[selRow+1][selCol].isOccupied())
                        return true;
                }
            }
            else {
                if(sqCol == selCol && sqRow == selRow + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMoveRook(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        if(sqRow == selRow) {
            if(sqCol > selCol) {
                boolean b = true;
                for(int i = selCol + 1; i <= sqCol; i++)
                    if(field[selRow][i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            else if(sqCol < selCol) {
                boolean b = true;
                for(int i = selCol - 1; i >= sqCol; i--)
                    if(field[selRow][i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        else if(sqCol == selCol) {
            if(sqRow > selRow) {
                boolean b = true;
                for(int i = selRow + 1; i <= sqRow; i++)
                    if(field[i][selCol].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            else if(sqRow < selRow) {
                boolean b = true;
                for(int i = selRow - 1; i >= sqRow; i--)
                    if(field[i][selCol].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMoveKnight(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        // 2 paces Up or Down
        if((selRow + sqRow) % 2 == 0) {
            // 1 pace Left
            if(sqCol == selCol - 1) {
                if(!sq.isOccupied()) {
                    return true;
                }
            }
            // 1 pace Right
            else if(sqCol == selCol + 1)
                if(!sq.isOccupied()) {
                    return true;
                }
        }
        // 1 pace Up or Down
        if((selRow + sqRow) % 2 == 1) {
            // 2 paces Left
            if(sqCol == selCol - 2) {
                if(!sq.isOccupied()) {
                    return true;
                }
            }
            // 2 paces Right
            else if(sqCol == selCol + 2)
                if(!sq.isOccupied()) {
                    return true;
                }
        }
        return false;
    }

    public boolean checkMoveBishop(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        // Up & Left or Down & Right
        if((selRow - selCol) == (sqRow - sqCol)) {
            // Up & Left
            if(selRow > sqRow) {
                boolean b = true;
                for(int i = 1; i <= selRow - sqRow; i++)
                    if(field[selRow-i][selCol-i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            // Down & Right
            else if(selRow < sqRow) {
                boolean b = true;
                for(int i = 1; i <= sqRow - selRow; i++)
                    if(field[selRow+i][selCol+i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        // Up & Right or Down & Left
        else if((selRow - sqRow) == -(selCol - sqCol)) {
            // Up & Right
            if(selRow > sqRow) {
                boolean b = true;
                for(int i = 1; i <= selRow - sqRow; i++)
                    if(field[selRow-i][selCol+i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            // Down & Left
            else if(selRow < sqRow) {
                boolean b = true;
                for(int i = 1; i <= sqRow - selRow; i++)
                    if(field[selRow+i][selCol-i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMoveKing(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        // Horizontal
        if(sqRow == selRow) {
            // Left
            if(sqCol == selCol - 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
            // Right
            else if(sqCol == selCol + 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
        }

        // Vertical
        else if(sqCol == selCol) {
            // Up
            if(sqRow == selRow - 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
            // Down
            else if(sqRow == selRow + 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
        }

        // Right Diagonal
        else if(selRow - sqRow == -(selCol - sqCol)) {
            // Up
            if(sqRow == selRow - 1 && sqCol == selCol + 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
            // Down
            else if(sqRow == selRow + 1 && sqCol == selCol - 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
        }

        // Left Diagonal
        else if((selRow - selCol) == (sqRow - sqCol)) {
            // Up
            if(sqRow == selRow - 1 && sqCol == selCol - 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
            // Down
            else if(sqRow == selRow + 1 && sqCol == selCol + 1) {
                if(!field[sqRow][sqCol].isOccupied()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMoveQueen(Piece p, Square sq, int sqRow, int sqCol) {
        if(selRow == sqRow && selCol == sqCol)
            return true;
        // ---------------------
        // Horizontal/Vertical
        //----------------------

        if(sqRow == selRow) {
            if(sqCol > selCol) {
                boolean b = true;
                for(int i = selCol + 1; i <= sqCol; i++)
                    if(field[selRow][i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            else if(sqCol < selCol) {
                boolean b = true;
                for(int i = selCol - 1; i >= sqCol; i--)
                    if(field[selRow][i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        else if(sqCol == selCol) {
            if(sqRow > selRow) {
                boolean b = true;
                for(int i = selRow + 1; i <= sqRow; i++)
                    if(field[i][selCol].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            else if(sqRow < selRow) {
                boolean b = true;
                for(int i = selRow - 1; i >= sqRow; i--)
                    if(field[i][selCol].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }


        //-----------
        // Diagonal
        //-----------

        // Up & Left or Down & Right
        else if((selRow - selCol) == (sqRow - sqCol)) {
            // Up & Left
            if(selRow > sqRow) {
                boolean b = true;
                for(int i = 1; i <= selRow - sqRow; i++)
                    if(field[selRow-i][selCol-i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            // Down & Right
            else if(selRow < sqRow) {
                boolean b = true;
                for(int i = 1; i <= sqRow - selRow; i++)
                    if(field[selRow+i][selCol+i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        // Up & Right or Down & Left
        else if((selRow - sqRow) == -(selCol - sqCol)) {
            // Up & Right
            if(selRow > sqRow) {
                boolean b = true;
                for(int i = 1; i <= selRow - sqRow; i++)
                    if(field[selRow-i][selCol+i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
            // Down & Left
            else if(selRow < sqRow) {
                boolean b = true;
                for(int i = 1; i <= sqRow - selRow; i++)
                    if(field[selRow+i][selCol-i].isOccupied())
                        b = false;
                if(b) {
                    return true;
                }
            }
        }
        return false;
    }
}
