package com.exodusgame.mode.RedSeaGameViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;

public class Anubis extends Item {

    public Anubis(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(getClass().getResource("/anubis.png"));
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
