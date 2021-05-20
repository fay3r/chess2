package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {

    private final RulesOfGame king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            " 1,  1,  2,  2",
            "8, 2, 8, 3",
            "3,  2, 4,  2 ",
            " 7,  1,  6,  1 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  2,  5,  6 ",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
