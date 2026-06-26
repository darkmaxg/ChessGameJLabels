package chess.pieces;

import javax.swing.*;

public class ChessSprite {
    protected int boardX;
    protected int boardY;
    private boolean highlighted = false;
    private final ImageIcon normalIcon;
    private final ImageIcon highlightedIcon;

    enum Color {WHITE, BLACK};

    public ChessSprite(String imagefile, String highlightedImageFile, int boardX, int boardY){
        this.boardX = boardX;
        this.boardY = boardY;
        normalIcon = new ImageIcon(imagefile);
        highlightedIcon = new ImageIcon(highlightedImageFile);
    }

    public int getBoardX(){ return boardX; }

    public void setBoardX(int val){boardX = val;}

    public int getBoardY(){ return boardY; }

    public void setBoardY(int val){boardY = val;}

    public boolean getHighlighted(){ return highlighted; }

    public void setHighlighted(boolean val) {highlighted = val;}

    public ImageIcon getNormalIcon(){ return normalIcon; }

    public ImageIcon getHighlightedIcon() { return highlightedIcon; }

    public ImageIcon getCurrentIcon(){
        if (highlighted){
            return highlightedIcon;
        }
        return normalIcon;
    }
}
