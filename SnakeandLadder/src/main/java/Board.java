import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int snakes, int ladders) {
        initializeCells(boardSize);
        addSnakesLadders(snakes, ladders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for(int i = 0;i < boardSize;i++) {
            for(int j = 0;j < boardSize;j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void addSnakesLadders(int noOfSnakes, int noOfLadders) {
        while(noOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length - 1);

            if(snakeHead <= snakeTail) continue;

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            noOfSnakes--;
        }

        while(noOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length - 1);

            if(ladderStart >= ladderEnd) continue;

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;
            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            noOfLadders--;
        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = playerPosition % cells.length;
        return cells[boardRow][boardColumn];
    }
}
