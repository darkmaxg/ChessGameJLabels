package chess.pieces;

import javax.swing.*;

public class ChessSprite {
    protected int boardX;
    protected int boardY;
    private boolean highlighted = false;
    private ImageIcon normalIcon = null;
    private ImageIcon highlightedIcon = null;

    enum Color {WHITE, BLACK};

    String imagefile;
    String highlightedImageFile;

    public ChessSprite(String imagefile, String highlightedImageFile, int boardX, int boardY){
        this.boardX = boardX;
        this.boardY = boardY;
        this.imagefile = imagefile;
        this.highlightedImageFile = highlightedImageFile;
    }

    public int getBoardX(){ return boardX; }

    public int getBoardY(){ return boardY; }

    public boolean isHighlighted(){ return highlighted; }

    public ImageIcon getNormalIcon(){ return normalIcon; }

    public ImageIcon getHighlightedIcon() { return highlightedIcon; }

    public ImageIcon getCurrentIcon(){
        if (highlighted){
            return highlightedIcon;
        }
        return normalIcon;
    }
}
