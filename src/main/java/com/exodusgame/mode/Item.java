package com.exodusgame.mode;

import javax.swing.*;
import java.awt.*;

import static com.exodusgame.Game.CELL_SIZE;

public abstract class Item {
    protected ImageIcon img;
    protected Point relativePosition;
    protected Point absolutePosition;

    public void draw(Graphics g){
        if(this.relativePosition != null) img.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }

    public void setPosition(int x, int y){
        absolutePosition = new Point((x -1) * CELL_SIZE, (y -1) * CELL_SIZE);
        relativePosition = new Point(x, y);
    }

    public void setPosition(Point p){
        setPosition(p.x, p.y);
    }

    public void setNullPosition(){
        relativePosition = null;
        absolutePosition = null;
    }

    public Point getRelativePosition(){
        if(relativePosition == null){
            return null;
        }
        return new Point(relativePosition);
    }

    public Point getAbsolutePosition(){
        if(absolutePosition == null){
            return null;
        }
        return new Point(absolutePosition);
    }

    public abstract String overlap(int x, int y);

}
