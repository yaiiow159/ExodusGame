package com.exodusgame.gameview;

import com.exodusgame.mode.Door;
import com.exodusgame.mode.RedSeaGameViewMode.Anubis;
import com.exodusgame.mode.RedSeaGameViewMode.Cat;
import com.exodusgame.mode.RedSeaGameViewMode.Pharaoh;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class RedSeaGameView extends GameView {

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public ArrayList<Anubis> getAnubis() {
        return anubis;
    }

    public ArrayList<Pharaoh> getPharoahs() {
        return pharoahs;
    }

    public ArrayList<Cat> cats = new ArrayList<>();
    public ArrayList<Anubis> anubis = new ArrayList<>();
    public ArrayList<Pharaoh> pharoahs = new ArrayList<>();

    public RedSeaGameView() {
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sea.jpg")));
        elements = new ArrayList<>();
        door = new Door(10, 10);

        cats.add(new Cat(6, 3));
        cats.add(new Cat(6, 4));
        cats.add(new Cat(6, 5));
        cats.add(new Cat(8, 3));
        cats.add(new Cat(1, 3));
        cats.add(new Cat(6, 9));
        cats.add(new Cat(2, 7));
        cats.add(new Cat(2, 5));

        pharoahs.add(new Pharaoh(5, 4));
        pharoahs.add(new Pharaoh(6, 1));
        pharoahs.add(new Pharaoh(5, 1));
        pharoahs.add(new Pharaoh(4, 1));
        pharoahs.add(new Pharaoh(3, 1));
        pharoahs.add(new Pharaoh(1, 4));

        anubis.add(new Anubis(2, 6));
        anubis.add(new Anubis(7, 6));
        anubis.add(new Anubis(7, 7));
        anubis.add(new Anubis(7, 8));
        anubis.add(new Anubis(10, 1));

        elements.addAll(anubis);
        elements.addAll(pharoahs);
        elements.addAll(cats);
        elements.add(door);
    }

}
