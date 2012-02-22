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
public class ColumnNames extends JPanel {

    public ColumnNames() {
        super();
        setPreferredSize(new Dimension(400,40));
        setLayout(new GridLayout(1,10));
        setBackground(Color.WHITE);
        
        JLabel filler1 = new JLabel();
        JLabel filler2 = new JLabel();
        filler1.setPreferredSize(new Dimension(20,20));
        filler2.setPreferredSize(new Dimension(20,20));

        add(filler1);
        for(int i = 0; i < 8; i++) {
            JLabel j = new JLabel("" + ChessMaster.COLS[i]);
            j.setPreferredSize(new Dimension(40,20));
            j.setHorizontalAlignment(SwingConstants.CENTER);
            add(j);
        }
        add(filler2);
    }
}
