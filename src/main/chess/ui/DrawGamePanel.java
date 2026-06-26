package chess.ui;

import chess.pieces.ChessBoard;
import chess.pieces.ChessPiece;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawGamePanel extends GamePanel implements MouseMotionListener {
    private Color highlightColor = new Color(125, 125, 255);
    private Color darkColor = Color.LIGHT_GRAY;
    private Color lightColor = Color.WHITE;

    private ChessBoard board;
    private int fieldSize = 60;

    private ChessPiece highlightedPiece;

    public DrawGamePanel(int fieldSize){
        super(fieldSize);
        board = new ChessBoard();
        this.fieldSize = fieldSize;
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(8*fieldSize, 8*fieldSize));
    }

    @Override
    public void updateGUI() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintBoard((Graphics2D) g);
        for(ChessPiece piece : board.getPieces()){
            g.drawImage(piece.getCurrentIcon().getImage(), piece.getBoardX() * fieldSize, piece.getBoardY() * fieldSize, null);
        }
    }

    public void paintBoard(Graphics2D g2d){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                g2d.setColor((x + y) % 2 == 0 ? lightColor : darkColor);
                if(board.getFields()[x][y].getHighlighted()){
                    g2d.setColor(highlightColor);
                }
                g2d.fillRect(x * fieldSize, y * fieldSize, fieldSize, fieldSize);
            }
        }
        g2d.setColor(Color.BLACK);
        for(int i = 0; i <= 8; i++){
            g2d.drawLine(i*fieldSize, 0, i*fieldSize, 8*fieldSize);
            g2d.drawLine(0, i*fieldSize, 8*fieldSize, i*fieldSize);
        }
    }

    private boolean overPiece(Point point, ChessPiece piece){
        return point.x >= (piece.getBoardX() * fieldSize) && point.x < piece.getBoardX() * fieldSize + fieldSize && point.y >= (piece.getBoardY() * fieldSize) && point.y < piece.getBoardY() * fieldSize + fieldSize;
    }

    private void highlightMovableFields(ChessPiece p){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(p.canMoveTo(x,y)){
                    board.highlight(x,y);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        ChessPiece current = null;
        for (ChessPiece piece : board.getPieces()) {
            if (overPiece(p, piece)) {
                current = piece;
                break;
            }
        }
        if (current == highlightedPiece) {
            return;
        }
        board.unhighlightAll();
        if (highlightedPiece != null) {
            highlightedPiece.setHighlighted(false);
        }
        if (current != null) {
            current.setHighlighted(true);
            highlightMovableFields(current);
        }
        highlightedPiece = current;
        updateGUI();
    }
}
