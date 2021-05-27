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
    private ClassProvider classProvider;

    public ChessFacade(MoveConverter moveConverter, ClassProvider classProvider) {
        this.moveConverter =moveConverter;
        this.classProvider = classProvider;
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
        return classProvider.provide(figureMoveDto.getType()).isCorrectMove(figureMove.getSource(),figureMove.getDestination());
    }
}
