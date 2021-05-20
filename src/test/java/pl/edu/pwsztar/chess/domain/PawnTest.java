package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {

    private final RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            " 1,  1,  2, 1",
            " 4, 2, 5, 2",
            " 6, 7, 7,   7 ",
            " 5,  8,  6,  8 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  6,  7,   5",
            "3, 2, 7,  8"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
