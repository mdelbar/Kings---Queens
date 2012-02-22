/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import XML.ChessXMLReader;
import chessmaster.GameFrame;

/**
 *
 * @author Matthias
 */
public class NewGameRunnable implements Runnable {

    private ChessXMLReader reader;

    public NewGameRunnable(ChessXMLReader reader) {
        this.reader = reader;
    }

    public void run() {
        new GameFrame(reader.getBoard(), reader.getMovesMade(),
                reader.getPiecesTaken(), reader.getPlayer());
    }
}
