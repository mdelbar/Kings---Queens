
package chessmaster;

import board.Board;
import info.kills.PiecesTakenPanel;
import info.moves.MovesMadePanel;
import javax.swing.JFrame;

/**
 *
 * @author Matthias
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        super("ChessMaster");

        setResizable(false);

        Game game = new Game();
        setJMenuBar(new ChessMenuBar(game, this));
        add(game);

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public GameFrame(Board board, MovesMadePanel movesMade, 
            PiecesTakenPanel piecesTaken, boolean turn) {
        super("ChessMaster");

        Game game = new Game(board, movesMade, piecesTaken, turn);
        setJMenuBar(new ChessMenuBar(game, this));
        add(game);

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
