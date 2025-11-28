package backend.academy.seminar10.refactor_tasks.game;

import java.util.List;
import java.util.Set;

public class Game {
    private static final int BOARD_SIZE = 12;
    private static final int WINNING_PURSE = 6;

    private final int dummyAnswer;
    private final List<PlayerState> players;
    private final WordBank wordBank;

    private GameState state = GameState.WAITING_FOR_ROLL;
    private PlayerState currentPlayer;

    public Game(Set<String> playerNames, int dummyAnswer, WordBank wordBank) {
        if (playerNames.size() < 2) {
            throw new IllegalArgumentException("Game must have at least 2 players");
        }
        this.wordBank = wordBank;
        this.dummyAnswer = dummyAnswer;
        this.players = playerNames.stream().map(PlayerState::new).toList();
        this.currentPlayer = this.players.get(0);
    }

    public boolean roll(int dice) {
        ensureState(GameState.WAITING_FOR_ROLL);

        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + dice);

        boolean freedFromPenalty = attemptToFree(dice);
        if (freedFromPenalty) {
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
        }

        if (currentPlayer.getState() == PlayerState.State.PENALTY) {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");

            nextPlayer();
            return true;
        }

        currentPlayer.move(dice, BOARD_SIZE);
        System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPlace());
        state = GameState.WAITING_FOR_QUESTION;
        return false;
    }

    private boolean attemptToFree(int dice) {
        if (currentPlayer.getState() != PlayerState.State.PENALTY) {
            return false;
        }

        if (dice % 2 != 0) {
            currentPlayer.releaseFromPenalty();
            return true;
        }
        return false;
    }

    public boolean answer(int userAnswer) {
        ensureState(GameState.WAITING_FOR_ANSWER);

        if (currentPlayer.getState() != PlayerState.State.FREE) {
            throw new IllegalStateException("Cannot answer from penalty box");
        }

        boolean winner = isWinningAnswer(userAnswer);
        if (winner) {
            state = GameState.FINISHED;
            return true;
        }
        nextPlayer();
        state = GameState.WAITING_FOR_ROLL;
        return false;
    }

    private boolean isWinningAnswer(int userAnswer) {
        if (userAnswer == dummyAnswer) {
            System.out.println("Question was incorrectly answered");
            System.out.println(currentPlayer.getName() + " was sent to the penalty box");
            currentPlayer.sendToPenalty();
            return false;
        } else {
            System.out.println("Answer was correct!!!!");
            currentPlayer.addCoin();
            System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurse() + " Gold Coins.");
            return currentPlayer.getPurse() == WINNING_PURSE;
        }

    }

    public void askQuestion() {
        ensureState(GameState.WAITING_FOR_QUESTION);

        WordBank.Theme category = questionCategoryForPlayer(currentPlayer);
        System.out.println("The category is " + category);
        String question = wordBank.question(category);
        System.out.println(question);
        state = GameState.WAITING_FOR_ANSWER;
    }

    private void nextPlayer() {
        int index = players.indexOf(currentPlayer);
        if (index != (players.size() - 1)) {
            currentPlayer= players.get(index + 1);
        } else {
            currentPlayer= players.get(0);
        }
    }

    private WordBank.Theme questionCategoryForPlayer(PlayerState player) {
        int positionIndex = player.getPlace() % 4;
        return switch (positionIndex) {
            case 0 -> WordBank.Theme.POP;
            case 1 -> WordBank.Theme.SCIENCE;
            case 2 -> WordBank.Theme.SPORT;
            default -> WordBank.Theme.ROCK;
        };
    }
    private void ensureState(GameState expected) {
        if (state != expected) {
            throw new IllegalStateException("Expected state " + expected + " but was " + state);
        }
    }
}
