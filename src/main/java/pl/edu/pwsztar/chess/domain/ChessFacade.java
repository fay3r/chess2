package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

@Transactional
public class ChessFacade {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame king;
    private RulesOfGame queen;
    private RulesOfGame pawn;
    private RulesOfGame rook;
    private MoveConverter moveConverter;
    // ...

    public ChessFacade(MoveConverter moveConverter) {
        this.moveConverter =moveConverter;
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        king = new RulesOfGame.King();
        queen = new RulesOfGame.Queen();
        rook = new RulesOfGame.Rook();
        pawn = new RulesOfGame.Pawn();
        // ...
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {

        FigureMove figureMove = moveConverter.toFigureMove(figureMoveDto);
        switch (figureMove.getType()) {
            case BISHOP:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return bishop.isCorrectMove(figureMove.getSource(), figureMove.getDestination());
            case KNIGHT:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return knight.isCorrectMove(figureMove.getSource(), figureMove.getDestination());
            case KING:
                return king.isCorrectMove(figureMove.getSource(),figureMove.getDestination());
            case PAWN:
                return pawn.isCorrectMove(figureMove.getSource(),figureMove.getDestination());
            case ROCK:
                return rook.isCorrectMove(figureMove.getSource(),figureMove.getDestination());
            case QUEEN:
                return queen.isCorrectMove(figureMove.getSource(),figureMove.getDestination());
        }

        return false;
    }
}
