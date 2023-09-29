package com.exodusgame.mode.disasterViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;
import java.util.Objects;

public class Ice extends Item {

    public Ice(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/ice.png")));
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
