package com.exodusgame.mode.RedSeaGameViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;

public class Cat extends Item {

    public Cat(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(getClass().getResource("/cat.png"));
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
