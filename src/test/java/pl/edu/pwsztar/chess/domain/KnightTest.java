package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    private final RulesOfGame knight = new RulesOfGame.Knight();

    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            "3,  6, 1,  5",
            "8, 2, 6, 1",
            "5, 7, 7,  6 ",
            " 1,  2,  2,  4 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "5,  5,  8,   1",
            "4, 2, 4,  1"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
