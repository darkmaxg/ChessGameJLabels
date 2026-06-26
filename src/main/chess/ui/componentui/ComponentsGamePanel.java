package chess.ui.componentui;

import chess.pieces.ChessField;
import chess.pieces.ChessPiece;
import chess.pieces.ChessSprite;
import chess.ui.GamePanel;

import java.util.ArrayList;
import java.util.List;

public class ComponentsGamePanel extends GamePanel {
    private ArrayList<PieceLabel> labels = new ArrayList<>();

    public ComponentsGamePanel(int fieldSize) {
        super(fieldSize);
        setLayout(null);
        ChessField[][] fields = getBoard().getFields();
        ChessPieceMouseListener listener = new ChessPieceMouseListener(this);
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessSprite field = fields[x][y];
                PieceLabel pieceLabel = new PieceLabel(field);
                pieceLabel.setBounds(field.getBoardX() * fieldSize, field.getBoardY() * fieldSize, fieldSize, fieldSize);
                pieceLabel.addMouseListener(listener);
                add(pieceLabel);
                labels.add(pieceLabel);
            }
        }
        List<ChessPiece> pieces = getBoard().getPieces();
        for(ChessPiece piece : pieces){
            PieceLabel pieceLabel = new PieceLabel(piece);
            pieceLabel.setBounds(piece.getBoardX() * fieldSize, piece.getBoardY() * fieldSize, fieldSize, fieldSize);
            pieceLabel.addMouseListener(listener);
            add(pieceLabel, 0);
            labels.add(pieceLabel);
        }
    }

    @Override
    public void updateGUI() {
        for(PieceLabel l : labels) {
            l.updateIcon();
        }
        repaint();
    }
}
