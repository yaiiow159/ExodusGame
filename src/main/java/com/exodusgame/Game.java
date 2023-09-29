package com.exodusgame;

import com.exodusgame.gameview.DisasterView;
import com.exodusgame.gameview.GameView;
import com.exodusgame.gameview.RedSeaGameView;
import com.exodusgame.mode.Item;
import com.exodusgame.mode.Mose;
import com.exodusgame.mode.RedSeaGameViewMode.Anubis;
import com.exodusgame.mode.RedSeaGameViewMode.Cat;
import com.exodusgame.mode.RedSeaGameViewMode.Pharaoh;
import com.exodusgame.mode.disasterViewMode.Bug;
import com.exodusgame.mode.disasterViewMode.Frog;
import com.exodusgame.mode.disasterViewMode.Ice;
import com.exodusgame.mode.disasterViewMode.TombStone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int CELL_SIZE = 50;
    public static final int COL = WIDTH / CELL_SIZE;
    public static final int ROW = HEIGHT / CELL_SIZE;
    Mose mose;
    public static GameView gameView;

    private static int level;

    public Game() {
        level = 1;
        mose = new Mose(1,1);
        resetGame(new DisasterView());
        addKeyListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exodus Game");
        frame.setTitle("Exodus Game");
        frame.setContentPane(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        gameView.draw(g);
        mose.draw(g);
        requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point mosesPoint = mose.getRelativePosition();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (mosesPoint.y > 1) {
                    String result = mose.overlap(mosesPoint.x, mosesPoint.y - 1);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("CannotMove")) {
                        mosesPoint.y -= 1;
                    }
                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (mosesPoint.y < ROW) {
                    String result = mose.overlap(mosesPoint.x, mosesPoint.y + 1);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("CannotMove")) {
                        mosesPoint.y += 1;
                    }
                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (mosesPoint.x < COL) {
                            String result = mose.overlap(mosesPoint.x + 1, mosesPoint.y);
                            if (result.equals("Die")) {
                                // reset game
                                level = 1;
                                JOptionPane.showMessageDialog(this, "You die. Please try again.");
                                resetGame(new DisasterView());
                                return;
                            }
                            if (!result.equals("CannotMove")) {
                                mosesPoint.x += 1;
                            }
                            if (result.equals("Game over")) {
                                JOptionPane.showMessageDialog(this, "You win the game!!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (mosesPoint.x > 1) {
                    String result = mose.overlap(mosesPoint.x - 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x -= 1;
                    }
                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;

            case KeyEvent.VK_W:
                for (int i = mosesPoint.y; i > 0; i--) {
                    for (Item s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == mosesPoint.x && s.getRelativePosition().y  == i) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof TombStone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_S:
                for (int i = mosesPoint.y; i <= ROW; i++) {
                    for (Item s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == mosesPoint.x && s.getRelativePosition().y  == i) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof TombStone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_D:
                for (int i = mosesPoint.x; i <= COL; i++) {
                    for (Item s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == i && s.getRelativePosition().y  == mosesPoint.y) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof TombStone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_A:
                for (int i = mosesPoint.x; i > 0; i--) {
                    for (Item s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == i && s.getRelativePosition().y  == mosesPoint.y) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof TombStone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
        }
        mose.setPosition(mosesPoint);
        repaint();
    }

    private boolean changeLevel(String result) {
        if (result.equals("Next level")) {
            level++;
            if (level == 2) {
                resetGame(new RedSeaGameView());
            }
            return true;
        }
        return false;
    }

    private void resetGame(GameView gameView) {
        Game.gameView = gameView;
        mose = new Mose(1,1);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
