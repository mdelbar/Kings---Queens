/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XML;

import board.Board;
import board.Square;
import chessmaster.ChessMaster;
import chessmaster.Game;
import chessmaster.Piece;
import info.InfoPanel;
import info.kills.PiecesBlack;
import info.kills.PiecesTakenPanel;
import info.kills.PiecesWhite;
import info.moves.MovesBlack;
import info.moves.MovesMadePanel;
import info.moves.MovesWhite;
import javax.swing.JLabel;
import org.jdom.Document;
import org.jdom.Element;

/**
 *
 * @author Matthias
 */
public class ChessDocument extends Document {

    private Game game;
    private Board board;
    private InfoPanel infoPanel;

    private Element root;

    public ChessDocument(Game game) {
        this.game = game;
        board = game.getBoardPanel().getBoard();
        infoPanel = game.getInfoPanel();

        root = new Element("game");

        addPlayer();
        addBoard();
        addMoves();
        addPieces();

        addContent(root);
    }

    public void addPlayer() {
        root.addContent(new Element("player").addContent("" + ChessMaster.player));
    }

    public void addBoard() {
        Element el = new Element("field");
        Square[][] field = board.getField();
        for(int i = 0; i < 8; i++) {
            Element row = new Element("row" + i);
            for(int j = 0; j < 8; j++) {
                Piece p = field[i][j].getPiece();
                if(field[i][j].isOccupied() && p != null)
                    row.addContent(new Element("col" + j).addContent(p.getPieceName()
                            + "-" + p.getColor()));
            }
            if(row.getContentSize() != 0)
                el.addContent(row);
        }
        root.addContent(el);
    }

    public void addMoves() {
        Element moves = new Element("moves");
        MovesMadePanel movesMade = infoPanel.getMovesMade();
        MovesWhite movesWhite = movesMade.getMovesWhite();
        MovesBlack movesBlack = movesMade.getMovesBlack();
        for(int i = 0; i < movesWhite.getComponentCount(); i++) {
            Element turn = new Element("turn" + (i+1));
            Element white = new Element("white");
            white.addContent(((JLabel) movesWhite.getComponent(i)).getText());
            
            Element black = new Element("black");
            // If White has already moved, but Black hasn't moved yet.
            if(movesBlack.getComponentCount() > i)
                black.addContent(((JLabel) movesBlack.getComponent(i)).getText());
            turn.addContent(white);
            turn.addContent(black);

            moves.addContent(turn);
        }
        root.addContent(moves);
    }

    public void addPieces() {
        Element pieces = new Element("pieces");
        PiecesTakenPanel piecesTaken = infoPanel.getPiecesTaken();
        PiecesWhite piecesWhite = piecesTaken.getPiecesWhite();
        PiecesBlack piecesBlack = piecesTaken.getPiecesBlack();
        if(piecesWhite.getComponentCount() > 0) {
            Element white = new Element("white");
            for(int i = 0; i < piecesWhite.getComponentCount(); i++) {
                Element piece = new Element("piece" + (i+1));
                Piece p = (Piece) piecesWhite.getComponent(i);
                piece.addContent(p.getPieceName() + "-" + p.getColor());

                white.addContent(piece);
            }
            pieces.addContent(white);
        }
        if(piecesBlack.getComponentCount() > 0) {
            Element black = new Element("black");
            for(int i = 0; i < piecesBlack.getComponentCount(); i++) {
                Element piece = new Element("piece" + (i+1));
                Piece p = (Piece) piecesBlack.getComponent(i);
                piece.addContent(p.getPieceName() + "-" + p.getColor());

                black.addContent(piece);
            }
            pieces.addContent(black);
        }
        root.addContent(pieces);
    }
}
