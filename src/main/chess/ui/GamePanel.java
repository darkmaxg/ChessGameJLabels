package chess.ui;

import chess.pieces.ChessBoard;

import javax.swing.*;
import java.awt.*;

public abstract class GamePanel extends JPanel {
    private ChessBoard board;
    private int fieldSize;

    public GamePanel(int fieldSize){
        board = new ChessBoard();
        this.fieldSize = fieldSize;
        setSize(new Dimension(8*this.getFieldSize(), 8*this.getFieldSize()));
        setPreferredSize(new Dimension(8*this.getFieldSize(), 8*this.getFieldSize()));
    }

    public int getFieldSize() {return fieldSize;}

    public ChessBoard getBoard() {return board;}

    public abstract void updateGUI();
}
