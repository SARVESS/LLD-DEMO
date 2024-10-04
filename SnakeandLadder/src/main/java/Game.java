import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player p1 = new Player("hercules51", 0);
        Player p2 = new Player("Iamvkundra61", 0);
        playerList.add(p1);
        playerList.add(p2);
    }

    public void startGame() {
        while(winner == null) {
            // check the turn now
            Player playerWithTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerWithTurn.id + " current position is: " + playerWithTurn.currentPosition);

            // roll the dice
            int diceNumbers = dice.rollDice();

            // get the new position
            int playerNewPosition = playerWithTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerWithTurn.currentPosition = playerNewPosition;

            if(playerNewPosition >= board.cells.length * board.cells.length - 1) {
                System.out.println("winner players turn " + playerWithTurn.id + " current position is: " + playerWithTurn.currentPosition);
                winner = playerWithTurn;
            }
        }
        System.out.println("WINNER IS:" + winner.id);
    }

    private Player findPlayerTurn() {
        Player playerWithTurn = playerList.removeFirst();
        playerList.addLast(playerWithTurn);
        return playerWithTurn;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length - 1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
