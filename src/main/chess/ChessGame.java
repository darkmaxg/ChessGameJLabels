package chess;

import chess.ui.componentui.ComponentsGamePanel;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JFrame {
    public ChessGame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new ComponentsGamePanel(60));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new ChessGame().setVisible(true);
    }
}