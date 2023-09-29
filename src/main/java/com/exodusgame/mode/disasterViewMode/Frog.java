package com.exodusgame.mode.disasterViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;
import java.util.Objects;

public class Frog extends Item {

    public Frog(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/frog.png")));
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
