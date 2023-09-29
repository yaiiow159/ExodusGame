package com.exodusgame.gameview;

import com.exodusgame.Game;
import com.exodusgame.mode.Door;
import com.exodusgame.mode.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class GameView {
    protected ArrayList<Item> elements;
    protected Door door;
    protected ImageIcon img;

    public void draw(Graphics g){
        img.paintIcon(null, g, 0, 0);
        g.setColor(new Color(0f, 0f, 0f, 0.3f));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for (Item item : elements) {
            item.draw(g);
        }
    }

    public Door getDoor(){
        return door;
    };

    public ArrayList<Item> getElements() {
        return elements;
    }
}
