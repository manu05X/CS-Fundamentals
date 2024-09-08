package com.manish.OOD.StructuralDesign.Flyweight.Example2;

import javax.swing.*;
import java.awt.*;

// Game class
public class Game extends JPanel {
    private TreeFactory treeFactory = new TreeFactory();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderForest(g);
    }

    public void renderForest(Graphics g) {
        // Render 1000 trees
        for (int i = 0; i < 1000; i++) {
            Tree tree = treeFactory.getTree("oak");
            tree.setPosition(i * 10, 0);
            tree.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Forest Simulation");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

