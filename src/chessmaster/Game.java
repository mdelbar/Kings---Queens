/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import board.Board;
import info.InfoPanel;
import board.BoardPanel;
import info.kills.PiecesTakenPanel;
import info.moves.MovesMadePanel;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class Game extends JPanel {

    private BoardPanel boardPanel;
    private InfoPanel infoPanel;

    public Game() {
        super();
        setLayout(new GridLayout(1,2));

        infoPanel = new InfoPanel();
        boardPanel = new BoardPanel(infoPanel);
        add(boardPanel);
        add(infoPanel);
    }

    public Game(Board board, MovesMadePanel movesMade,
            PiecesTakenPanel piecesTaken, boolean turn) {
        super();
        setLayout(new GridLayout(1,2));

        infoPanel = new InfoPanel(movesMade, piecesTaken);
        boardPanel = new BoardPanel(board, infoPanel);
        add(boardPanel);
        add(infoPanel);
        ChessMaster.player = turn;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
}
