package chess;

import chess.ui.DrawGamePanel;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawGamePanel(60));
        pack();
    }

    static void main() {
        new MainWindow().setVisible(true);
    }
}
