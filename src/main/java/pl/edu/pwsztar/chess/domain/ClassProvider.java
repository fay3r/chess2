package pl.edu.pwsztar.chess.domain;

import pl.edu.pwsztar.chess.dto.FigureType;

import java.util.HashMap;

public class ClassProvider {

    private final HashMap<FigureType, RulesOfGame> typeToClass = new HashMap() {
        {
            put(FigureType.BISHOP, new RulesOfGame.Bishop());
            put(FigureType.ROCK, new RulesOfGame.Rook());
            put(FigureType.KING, new RulesOfGame.King());
            put(FigureType.KNIGHT, new RulesOfGame.Knight());
            put(FigureType.PAWN, new RulesOfGame.Pawn());
            put(FigureType.QUEEN, new RulesOfGame.Queen());
        }
    };

    public RulesOfGame provide(FigureType ft){
        return typeToClass.get(ft);
    }


}
