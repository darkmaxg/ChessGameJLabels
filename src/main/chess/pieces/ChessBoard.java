package chess.pieces;

public class ChessBoard {
    private final ChessField[][] fields;

    public ChessBoard(){
        fields = new ChessField[8][8];
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessSprite.Color color = (x + y) % 2 == 0
                        ? ChessSprite.Color.WHITE
                        : ChessSprite.Color.BLACK;
                fields[x][y] = new ChessField(x, y, color);
            }
        }
    }

    public ChessField[][] getFields() {return fields;}
}
