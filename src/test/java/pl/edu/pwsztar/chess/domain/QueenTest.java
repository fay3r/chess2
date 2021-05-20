package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {

    private final RulesOfGame queen = new RulesOfGame.Queen();

    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            " 4,  4,  5,  4",
            " 2, 1, 5, 4",
            " 2,  3, 8,   3 ",
            " 2,  5,  2,  8 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(queen.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "5,  5,  6,   2",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(queen.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
