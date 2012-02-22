/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import info.InfoPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class BoardPanel extends JPanel {

    private Board board;

    public BoardPanel(InfoPanel infoPanel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400,400));

        add(new ColumnNames(), BorderLayout.NORTH);
        add(new ColumnNames(), BorderLayout.SOUTH);
        add(new RowNames(), BorderLayout.EAST);
        add(new RowNames(), BorderLayout.WEST);
        board = new Board(infoPanel);
        add(board, BorderLayout.CENTER);
    }

    public BoardPanel(Board board, InfoPanel infoPanel) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400,400));

        add(new ColumnNames(), BorderLayout.NORTH);
        add(new ColumnNames(), BorderLayout.SOUTH);
        add(new RowNames(), BorderLayout.EAST);
        add(new RowNames(), BorderLayout.WEST);
        this.board = board;
        this.board.setInfoPanel(infoPanel);
        add(board, BorderLayout.CENTER);
    }

    public Board getBoard() {
        return board;
    }
}
