package com.exodusgame.mode.RedSeaGameViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;
import java.util.Objects;

public class Cat extends Item {

    public Cat(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/cat.png")));
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
