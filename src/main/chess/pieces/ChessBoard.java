package chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private ChessField[][] fields;
    private List<ChessPiece> pieces = new ArrayList<>();

    public ChessBoard(){
        setupBoard();
    }

    public ChessField[][] getFields() {return fields;}

    private void setupBoard(){
        fields = new ChessField[8][8];
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessSprite.Color color = (x + y) % 2 == 0
                        ? ChessSprite.Color.WHITE
                        : ChessSprite.Color.BLACK;
                fields[x][y] = new ChessField(x, y, color);
            }
        }
        for(int i = 0; i < 8; i++){
            pieces.add(new Pawn(this, i, 1, ChessSprite.Color.BLACK));
            pieces.add(new Pawn(this, i, 6, ChessSprite.Color.WHITE));
        }
    }

    public void highlight(int x, int y){
        fields[x][y].setHighlighted(true);
    }

    public void unhighlightAll(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                fields[x][y].setHighlighted(false);
            }
        }
    }

    public List<ChessPiece> getPieces(){
        return pieces;
    }
}
