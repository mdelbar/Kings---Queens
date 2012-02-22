/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chessmaster;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 *
 * @author Matthias
 */
public class MovesLayout implements LayoutManager {

    public MovesLayout() {
        
    }

    public void addLayoutComponent(String name, Component comp) {
        // Do nothing
    }

    public void removeLayoutComponent(Component comp) {
        // Do nothing
    }

    public Dimension preferredLayoutSize(Container parent) {
        int height = 0;
        int width = 0;

        int amount = parent.getComponentCount();
        for(int i = 0; i < amount; i++) {
            height += parent.getComponent(i).getPreferredSize().height;
        }

        for(int j = 0; j < amount; j++) {
            width = Math.max(width, parent.getComponent(j).getPreferredSize().width);
        }

        return new Dimension(height, width);
    }

    public Dimension minimumLayoutSize(Container parent) {
        int height = 0;
        int width = 0;

        int amount = parent.getComponentCount();
        for(int i = 0; i < amount; i++) {
            height += parent.getComponent(i).getMinimumSize().height;
        }

        for(int j = 0; j < amount; j++) {
            width = Math.max(width, parent.getComponent(j).getMinimumSize().width);
        }

        return new Dimension(height, width);
    }

    public void layoutContainer(Container parent) {
        int width = parent.getWidth();
        int amount = parent.getComponentCount();
//        for(int i = 0; i < amount; i++) {
//            width = Math.max(width, parent.getComponent(i).getMinimumSize().width);
//        }

        int yPos = 10;
        for(int j = 0; j < amount; j++) {
            Component c = parent.getComponent(j);
            int height = c.getPreferredSize().height;
            c.setBounds(20, yPos, width, height);
            yPos += 50;
        }
    }
}
