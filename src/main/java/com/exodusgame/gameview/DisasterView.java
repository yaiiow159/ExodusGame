package com.exodusgame.gameview;

import com.exodusgame.mode.Door;
import com.exodusgame.mode.disasterViewMode.Bug;
import com.exodusgame.mode.disasterViewMode.Frog;
import com.exodusgame.mode.disasterViewMode.Ice;
import com.exodusgame.mode.disasterViewMode.TombStone;

import javax.swing.*;
import java.util.ArrayList;

public class DisasterView extends GameView {
    private ArrayList<Bug> bugArrayList = new ArrayList<>();
    private ArrayList<Frog> frogArrayList = new ArrayList<>();
    private ArrayList<Ice> iceArrayList = new ArrayList<>();

    public ArrayList<Bug> getBugArrayList() {
        return bugArrayList;
    }

    public ArrayList<Frog> getFrogArrayList() {
        return frogArrayList;
    }

    public ArrayList<Ice> getIceArrayList() {
        return iceArrayList;
    }

    public ArrayList<TombStone> getTombStoneArrayList() {
        return tombStoneArrayList;
    }

    private ArrayList<TombStone> tombStoneArrayList = new ArrayList<>();

    public DisasterView() {
        img = new ImageIcon(getClass().getResource("/egypt.jpg"));
        elements = new ArrayList<>();
        door = new Door(10, 10);

        bugArrayList.add(new Bug(10, 5));
        bugArrayList.add(new Bug(9, 5));
        bugArrayList.add(new Bug(9, 4));
        bugArrayList.add(new Bug(9, 3));
        bugArrayList.add(new Bug(6, 5));
        bugArrayList.add(new Bug(6, 4));
        bugArrayList.add(new Bug(6, 3));

        frogArrayList.add(new Frog(1, 2));
        frogArrayList.add(new Frog(1, 3));
        frogArrayList.add(new Frog(1, 4));
        frogArrayList.add(new Frog(2, 2));
        frogArrayList.add(new Frog(2, 3));
        frogArrayList.add(new Frog(2, 5));

        iceArrayList.add(new Ice(7, 1));
        iceArrayList.add(new Ice(7, 2));
        iceArrayList.add(new Ice(7, 3));
        iceArrayList.add(new Ice(7, 5));

        tombStoneArrayList.add(new TombStone(6, 6));
        tombStoneArrayList.add(new TombStone(7, 8));
        tombStoneArrayList.add(new TombStone(8, 8));
        tombStoneArrayList.add(new TombStone(9, 8));
        tombStoneArrayList.add(new TombStone(3, 8));

        elements.addAll(bugArrayList);
        elements.addAll(frogArrayList);
        elements.addAll(iceArrayList);
        elements.addAll(tombStoneArrayList);
        elements.add(door);
    }
}
