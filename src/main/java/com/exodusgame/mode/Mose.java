package com.exodusgame.mode;

import com.exodusgame.Game;
import com.exodusgame.gameview.DisasterView;
import com.exodusgame.gameview.RedSeaGameView;
import com.exodusgame.mode.RedSeaGameViewMode.Anubis;
import com.exodusgame.mode.RedSeaGameViewMode.Cat;
import com.exodusgame.mode.RedSeaGameViewMode.Pharaoh;
import com.exodusgame.mode.disasterViewMode.Bug;
import com.exodusgame.mode.disasterViewMode.Frog;
import com.exodusgame.mode.disasterViewMode.Ice;
import com.exodusgame.mode.disasterViewMode.TombStone;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Mose extends Item {

    public Mose(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Moses.png")));
    }

    @Override
    public String overlap(int x, int y) {
                if(Game.gameView instanceof DisasterView) {
                    // check if touch on frog and bug
                    ArrayList<Frog> frogs = ((DisasterView) Game.gameView).getFrogArrayList();
                    ArrayList<Bug> bugs = ((DisasterView) Game.gameView).getBugArrayList();
                    for (Frog frog : frogs) {
                        if(frog.getRelativePosition() != null
                                && frog.getRelativePosition().x == x
                                && frog.getRelativePosition().y == y) {
                            return "Die";
                        }
                    }
                    for (Bug bug : bugs) {
                        if(bug.getRelativePosition() != null
                                && bug.getRelativePosition().x == x
                                && bug.getRelativePosition().y == y) {
                            return "Die";
                        }
                    }
                    // check if touch on ice or tombstone
                    ArrayList<Ice> ices = ((DisasterView) Game.gameView).getIceArrayList();
                    ArrayList<TombStone> tombStones = ((DisasterView) Game.gameView).getTombStoneArrayList();
            for (Ice ice : ices) {
                if(ice.getRelativePosition() != null
                        && ice.getRelativePosition().x == x
                        && ice.getRelativePosition().y == y) {
                    return "CannotMove";
                }
            }
            for (TombStone tombStone :tombStones) {
                if(tombStone.getRelativePosition() != null
                        && tombStone.getRelativePosition().x == x
                        && tombStone.getRelativePosition().y == y) {
                    return "CannotMove";
                }
            }
            Door door = Game.gameView.getDoor();
            if(door.getRelativePosition().x == x && door.getRelativePosition().y == y){
               return "Next level";
            }
        } else if (Game.gameView instanceof RedSeaGameView) {
            // check if touch on cat
            ArrayList<Cat> cats = ((RedSeaGameView) Game.gameView).getCats();
            ArrayList<Anubis> anuses = ((RedSeaGameView) Game.gameView).getAnubis();
            ArrayList<Pharaoh> pharaohs = ((RedSeaGameView) Game.gameView).getPharoahs();
            for (Cat cat : cats) {
                if(cat.getRelativePosition() != null
                        && cat.getRelativePosition().x == x
                        && cat.getRelativePosition().y == y) {
                    return "CannotMove";
                }
            }
            for ( Anubis anubis : anuses) {
                if(anubis.getRelativePosition() != null
                        && anubis.getRelativePosition().x == x
                        && anubis.getRelativePosition().y == y) {
                    return "Die";
                }
            }
            for (Pharaoh pharoah : pharaohs) {
                if(pharoah.getRelativePosition() != null
                        && pharoah.getRelativePosition().x == x
                        && pharoah.getRelativePosition().y == y) {
                    return "Die";
                }
            }
        }
        return "None";
    }
}
