/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package XML;

import board.Board;
import chessmaster.Piece;
import info.kills.PiecesBlack;
import info.kills.PiecesTakenPanel;
import info.kills.PiecesWhite;
import info.moves.MovesBlack;
import info.moves.MovesMadePanel;
import info.moves.MovesWhite;
import java.util.List;
import javax.swing.JLabel;
import org.jdom.Document;
import org.jdom.Element;

/**
 *
 * @author Matthias
 */
public class ChessXMLReader {

    private Element root;

    public ChessXMLReader(Document doc) {
        root = doc.getRootElement();
    }

    public Board getBoard() {
        Board board = new Board();
        board.removeAll();
        board.initField();

        Element field = root.getChild("field");
        for(Element rowEl : (List<Element>) field.getChildren()) {
            String rowName = rowEl.getName();
            int row = Integer.parseInt(rowName.substring(rowName.length()-1, rowName.length()));
            for(Element colEl : (List<Element>) rowEl.getChildren()) {
                String colName = colEl.getName();
                int col = Integer.parseInt(colName.substring(colName.length()-1, colName.length()));
                String elText = colEl.getText();

                board.setAtSquare(getPieceFromText(elText), row, col);
            }
        }

        board.paintField();
        return board;
    }

    public MovesMadePanel getMovesMade() {
        MovesMadePanel movesMade = new MovesMadePanel();
        MovesWhite white = movesMade.getMovesWhite();
        MovesBlack black = movesMade.getMovesBlack();
        Element moves = root.getChild("moves");

        for(Element turnEl : (List<Element>) moves.getChildren()) {
            white.add(new JLabel(turnEl.getChildText("white")));
            if(!turnEl.getChildText("black").isEmpty())
                black.add(new JLabel(turnEl.getChildText("black")));
        }

        return movesMade;
    }

    public PiecesTakenPanel getPiecesTaken() {
        PiecesTakenPanel piecesTaken = new PiecesTakenPanel();
        PiecesWhite white = piecesTaken.getPiecesWhite();
        PiecesBlack black = piecesTaken.getPiecesBlack();
        Element pieces = root.getChild("pieces");
        Element whiteEl = pieces.getChild("white");
        Element blackEl = pieces.getChild("black");

        if(whiteEl != null)
            for(Element piece : (List<Element>) whiteEl.getChildren())
                white.add(getPieceFromText(piece.getText()));
        if(blackEl != null)
            for(Element piece : (List<Element>) blackEl.getChildren())
                black.add(getPieceFromText(piece.getText()));

        return piecesTaken;
    }

    public boolean getPlayer() {
        if(root.getChildText("player").equals("true"))
            return true;
        else
            return false;
    }

    public Piece getPieceFromText(String elText) {
        int dashPos = elText.indexOf("-");
        String pieceName = elText.substring(0, dashPos);

        if(elText.substring(dashPos+1, elText.length()).equals("true"))
            return new Piece(pieceName, true);
        else
            return new Piece(pieceName, false);
    }
}
