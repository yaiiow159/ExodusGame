package com.exodusgame.mode;

import javax.swing.*;
import java.util.Objects;

public class Door extends Item {

    public Door(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/door.png")));
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
