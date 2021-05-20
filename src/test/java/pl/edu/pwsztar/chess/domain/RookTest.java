package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {

    private final RulesOfGame rook  = new RulesOfGame.Rook();

    @Tag("Rook")
    @ParameterizedTest
    @CsvSource({
            " 8,  1,  8,  8",
            "5, 2, 2, 2",
            "6,  4, 6,  6 ",
            " 1,  1,  8,  1 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rook.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  1,  3,   3",
            "2,2, 2,  2"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rook.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
