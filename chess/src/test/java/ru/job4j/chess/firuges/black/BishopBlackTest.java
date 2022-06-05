package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bb = new BishopBlack(Cell.C8);
        assertThat(bb.position(), is(Cell.C8));
    }

    @Test
    public void testCopy() {
        Figure bb = new BishopBlack(Cell.C3);
        assertThat(bb.copy(Cell.C3).position(), is(bb.position()));
    }

    @Test
    public void testWay() {
        Figure first = new BishopBlack(Cell.C1);
        Cell[] rsl = first.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(rsl));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testDiagonal() {
        Figure one = new BishopBlack(Cell.C1);
        one.way(Cell.D1);
    }
}