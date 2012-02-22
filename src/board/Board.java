/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.*;
import info.InfoPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthias
 */
public class Board extends MoveAndKillPanel {

    private SquaresMouseListener squaresMouseListener;
    private boolean selected;
    private InfoPanel infoPanel;

    public Board() {
        super();
        setLayout(new GridLayout(8,8));
        setPreferredSize(new Dimension(320,320));

        squaresMouseListener = new SquaresMouseListener(this);
        selSq = null;

        initField();
        initPieces();
        paintField();
    }

    public Board(InfoPanel infoPanel) {
        super();
        setLayout(new GridLayout(8,8));
        setPreferredSize(new Dimension(320,320));

        squaresMouseListener = new SquaresMouseListener(this);
        selSq = null;
        this.infoPanel = infoPanel;

        initField();
        initPieces();
        paintField();
    }

    public void setInfoPanel(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public void select(Square sq) {
        if(selRow != -1 && selCol != -1) {
            if((selRow + selCol) % 2 == 0)
                field[selRow][selCol].setBackground(ChessMaster.getLightColor());
            else
                field[selRow][selCol].setBackground(ChessMaster.getDarkColor());
        }
        selRow = sq.getRow();
        selCol = sq.getCol();
        selected = true;
        selSq = sq;
        sq.setBackground(ChessMaster.getSelectedSquareColor());
    }

    public void deselect() {
        if(selRow != -1 && selCol !=-1) {
            if((selRow + selCol) % 2 == 0)
                field[selRow][selCol].setBackground(ChessMaster.getLightColor());
            else
                field[selRow][selCol].setBackground(ChessMaster.getDarkColor());
            selRow = -1;
            selCol = -1;
            selected = false;
            selSq = null;
        }
    }

    public void tryMove(Square sq) {
        Piece p = selSq.getPiece();
        if(checkMove(p, sq)) {
            movePiece(p, selSq, sq);
        }
        else {
            JOptionPane.showMessageDialog(null, "Illegal move!", "Error", JOptionPane.ERROR_MESSAGE);
            deselect();
        }
    }

    public void movePiece(Piece p, Square oldSq, Square newSq) {
        oldSq.removeAll();
        oldSq.setOccupied(false);
        newSq.setPiece(p);
        deselect();
        infoPanel.pieceMoved(p, newSq);
        ChessMaster.moveMade();
        oldSq.repaint();
        newSq.repaint();
    }

    public void tryKill(Square sq) {
        Piece p = selSq.getPiece();
        if(checkKill(p, sq))
            killPiece(p, selSq, sq);
    }

    public void killPiece(Piece p, Square oldSq, Square newSq) {
        oldSq.removeAll();
        oldSq.setOccupied(false);
        infoPanel.pieceKilled(p, oldSq, newSq);
        newSq.setPiece(p);
        deselect();
        ChessMaster.moveMade();
        oldSq.repaint();
        newSq.repaint();
    }


    public boolean isSelected() {
        return selected;
    }

    public boolean isSquareSelected(Square sq) {
        if(selSq != null && selSq == sq)
            return true;
        else
            return false;
    }

    public void setAtSquare(Piece p, int i, int j) {
        field[i][j].setPiece(p);
    }

    public Square[][] getField() {
        return field;
    }



    //----------------------------------------------------------------
    // Init all the different pieces, and their placement on the board
    //----------------------------------------------------------------

    public void initField() {
        field = new Square[8][8];
        boolean color = true;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Square sq = new Square(color, squaresMouseListener, i, j);
                field[i][j] = sq;
                color = !color;
            }
            color = !color;
        }
    }

    public void initPieces() {
        initPawns();
        initRooks();
        initKnights();
        initBishops();
        initKings();
        initQueens();
    }

    public void paintField() {
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                add(field[i][j]);
    }

    
    private void initPawns() {
        for(int i = 0; i < 8; i++) {
            field[1][i].setPiece(new Piece("pion", false));
            field[6][i].setPiece(new Piece("pion", true));
        }
    }

    private void initRooks() {
        field[0][0].setPiece(new Piece("toren", false));
        field[0][7].setPiece(new Piece("toren", false));
        field[7][0].setPiece(new Piece("toren", true));
        field[7][7].setPiece(new Piece("toren", true));
    }

    private void initKnights() {
        field[0][1].setPiece(new Piece("paard", false));
        field[0][6].setPiece(new Piece("paard", false));
        field[7][1].setPiece(new Piece("paard", true));
        field[7][6].setPiece(new Piece("paard", true));
    }

    private void initBishops() {
        field[0][2].setPiece(new Piece("loper", false));
        field[0][5].setPiece(new Piece("loper", false));
        field[7][2].setPiece(new Piece("loper", true));
        field[7][5].setPiece(new Piece("loper", true));
    }

    private void initKings() {
        field[0][4].setPiece(new Piece("koning", false));
        field[7][4].setPiece(new Piece("koning", true));
    }

    private void initQueens() {
        field[0][3].setPiece(new Piece("dame", false));
        field[7][3].setPiece(new Piece("dame", true));
    }
}
