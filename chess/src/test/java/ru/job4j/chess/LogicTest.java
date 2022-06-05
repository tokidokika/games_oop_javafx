package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;

public class LogicTest {

    @Ignore
    @Test
    public void whenMoveSuccess()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenWayOccupied() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        logic.add(new QueenBlack(Cell.D3));
        logic.move(Cell.F1, Cell.C4);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenNoFigure() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.move(Cell.F1, Cell.C4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMove() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        logic.move(Cell.F1, Cell.F2);
    }
}