package com.exodusgame.mode.RedSeaGameViewMode;

import com.exodusgame.mode.Item;

import javax.swing.*;
import java.util.Objects;

public class Anubis extends Item {

    public Anubis(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/anubis.png")));
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
