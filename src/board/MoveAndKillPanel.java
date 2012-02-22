/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.Piece;

/**
 *
 * @author Matthias
 */
public class MoveAndKillPanel extends MovePanel {

    public MoveAndKillPanel() {
        super();
    }

    public boolean checkKill(Piece p, Square sq) {
        String name = p.getPieceName();
        int sqRow = sq.getRow();
        int sqCol = sq.getCol();

        if(name.equals("pion")) {
            return checkKillPawn(p, sq, sqRow, sqCol);
        }
        else if(name.equals("toren")) {
            return checkKillRook(p, sq, sqRow, sqCol);
        }
        else if(name.equals("paard")) {
            return checkKillKnight(p, sq, sqRow, sqCol);
        }
        else if(name.equals("loper")) {
            return checkKillBishop(p, sq, sqRow, sqCol);
        }
        else if(name.equals("dame")) {
            return checkKillQueen(p, sq, sqRow, sqCol);
        }
        else if(name.equals("koning")) {
            return checkKillKing(p, sq, sqRow, sqCol);
        }
        else
            return false;
    }

    public boolean checkKillPawn(Piece p, Square sq, int sqRow, int sqCol) {
        if(p.getColor()) {
            if(sqRow == selRow - 1) {
                if(sqCol == selCol - 1 || sqCol == selCol + 1) {
                    return true;
                }
            }
        }
        else {
            if(sqRow == selRow + 1) {
                if(sqCol == selCol - 1 || sqCol == selCol + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkKillRook(Piece p, Square sq, int sqRow, int sqCol) {
        if(sqRow == selRow) {
            if(sqCol > selCol) {
                if(checkMoveRook(p, field[sqRow][sqCol-1], sqRow, sqCol-1)) {
                    return true;
                }
            }
            else {
                if(checkMoveRook(p, field[sqRow][sqCol+1], sqRow, sqCol+1)) {
                    return true;
                }
            }
        }
        else if(sqCol == selCol) {
            if(sqRow > selRow) {
                if(checkMoveRook(p, field[sqRow-1][sqCol], sqRow-1, sqCol)) {
                    return true;
                }
            }
            else {
                if(checkMoveRook(p, field[sqRow+1][sqCol], sqRow+1, sqCol)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkKillKnight(Piece p, Square sq, int sqRow, int sqCol) {
        // 2 paces Up or Down
        if((selRow + sqRow) % 2 == 0) {
            // 1 pace Left
            if(sqCol == selCol - 1) {
                if(sq.isOccupied() && sq.getPiece().getColor() != p.getColor()) {
                    return true;
                }
            }
            // 1 pace Right
            else if(sqCol == selCol + 1)
                if(sq.isOccupied() && sq.getPiece().getColor() != p.getColor()) {
                    return true;
                }
        }
        // 1 pace Up or Down
        if((selRow + sqRow) % 2 == 1) {
            // 2 paces Left
            if(sqCol == selCol - 2) {
                if(sq.isOccupied() && sq.getPiece().getColor() != p.getColor()) {
                    return true;
                }
            }
            // 2 paces Right
            else if(sqCol == selCol + 2)
                if(sq.isOccupied() && sq.getPiece().getColor() != p.getColor()) {
                    return true;
                }
        }
        return false;
    }

    public boolean checkKillBishop(Piece p, Square sq, int sqRow, int sqCol) {
        // Up & Left or Down & Right
        if((selRow - selCol) == (sqRow - sqCol)) {
            // Up & Left
            if(selRow > sqRow) {
                if(checkMoveBishop(p, field[sqRow+1][sqCol+1], sqRow+1, sqCol+1)) {
                    return true;
                }
            }
            // Down & Right
            else if(selRow < sqRow) {
                if(checkMoveBishop(p, field[sqRow-1][sqCol-1], sqRow-1, sqCol-1)) {
                    return true;
                }
            }
        }
        // Up & Right or Down & Left
        else if((selRow - sqRow) == -(selCol - sqCol)) {
            // Up & Right
            if(selRow > sqRow) {
                if(checkMoveBishop(p, field[sqRow+1][sqCol-1], sqRow+1, sqCol-1)) {
                    return true;
                }
            }
            // Down & Left
            else if(selRow < sqRow) {
                if(checkMoveBishop(p, field[sqRow-1][sqCol+1], sqRow-1, sqCol+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkKillQueen(Piece p, Square sq, int sqRow, int sqCol) {
        if(checkKillRook(p, sq, sqRow, sqCol) || checkKillBishop(p, sq, sqRow, sqCol))
            return true;
        return false;
    }

    public boolean checkKillKing(Piece p, Square sq, int sqRow, int sqCol) {
        // Horizontal
        if(sqRow == selRow) {
            // Left
            if(sqCol == selCol - 1) {
                return true;
            }
            // Right
            else if(sqCol == selCol + 1) {
                return true;
            }
        }

        // Vertical
        else if(sqCol == selCol) {
            // Up
            if(sqRow == selRow - 1) {
                return true;
            }
            // Down
            else if(sqRow == selRow + 1) {
                return true;
            }
        }

        // Right Diagonal
        else if(selRow - sqRow == -(selCol - sqCol)) {
            // Up
            if(sqRow == selRow - 1 && sqCol == selCol + 1) {
                return true;
            }
            // Down
            else if(sqRow == selRow + 1 && sqCol == selCol - 1) {
                return true;
            }
        }

        // Left Diagonal
        else if((selRow - selCol) == (sqRow - sqCol)) {
            // Up
            if(sqRow == selRow - 1 && sqCol == selCol - 1) {
                return true;
            }
            // Down
            else if(sqRow == selRow + 1 && sqCol == selCol + 1) {
                return true;
            }
        }
        return false;
    }
}
