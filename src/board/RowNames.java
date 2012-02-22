/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package board;

import chessmaster.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Matthias
 */
public class RowNames extends JPanel {

    public RowNames() {
        super();
        setPreferredSize(new Dimension(40,320));
        setLayout(new GridLayout(8,1));
        setBackground(Color.WHITE);

        for(int i = 0; i < 8; i++) {
            JLabel j = new JLabel("" + ChessMaster.ROWS[i]);
            j.setHorizontalAlignment(SwingConstants.CENTER);
            add(j);
        }
    }
}
