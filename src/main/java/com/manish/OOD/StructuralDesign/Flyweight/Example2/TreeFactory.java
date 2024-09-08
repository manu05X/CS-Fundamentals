package com.manish.OOD.StructuralDesign.Flyweight.Example2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Flyweight factory
public class TreeFactory {
    private Map<String, Tree> treeMap = new HashMap<>();

    public Tree getTree(String type) {
        Tree tree = treeMap.get(type);

        if (tree == null) {
            // Create a new tree object
            Image image = loadImage(type + ".png");
            tree = new OakTree(image);

            // Add the new tree to the pool
            treeMap.put(type, tree);
        }

        return tree;
    }

    private Image loadImage(String filename) {
        try {
            // Load image from file
            BufferedImage bufferedImage = ImageIO.read(new File(filename));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB); // return a blank image in case of error
        }
    }
}
