package backend.academy.seminar10.refactor_tasks.game;

import java.util.List;
import java.util.Set;

public class Game {
    private static final int BOARD_SIZE = 12;
    private static final int WINNING_PURSE = 6;

    private Step step = Step.ROLL;

    private final int dummyAnswer;
    private final List<PlayerState> players;
    private final WordBank wordBank;

    private PlayerState player;

    public Game(Set<String> playerNames, int dummyAnswer, WordBank wordBank) {
        if (playerNames.size() < 2) {
            throw new IllegalArgumentException("Game must have at least 2 players");
        }
        this.wordBank = wordBank;
        this.dummyAnswer = dummyAnswer;
        this.players = playerNames.stream().map(PlayerState::new).toList();
        this.player = this.players.get(0);
    }

    public boolean roll(int dice) {
        if (step != Step.ROLL) {
            throw new IllegalStateException("Cannot roll dice at this step");
        }

        System.out.println(player.name + " is the current player");
        System.out.println("They have rolled a " + dice);

        boolean freedFromPenalty = attemptToFree(dice);
        if (freedFromPenalty) {
            System.out.println(player.name + " is getting out of the penalty box");
        }

        if (player.state == PlayerState.State.PENALTY) {
            System.out.println(player.name + " is not getting out of the penalty box");

            nextPlayer();
            return true;
        }

        player.place = (player.place + dice) % BOARD_SIZE;
        System.out.println(player.name + "'s new location is " + player.place);
        step = Step.QUESTION;
        return false;
    }

    private boolean attemptToFree(int dice) {
        if (player.state != PlayerState.State.PENALTY) {
            return false;
        }

        if (dice % 2 != 0) {
            player.state = PlayerState.State.FREE;
            return true;
        }
        return false;
    }

    public boolean answer(int userAnswer) {
        if (step != Step.ANSWER) {
            throw new IllegalStateException("Cannot answer before rolling dice");
        }

        if (player.state != PlayerState.State.FREE) {
            throw new IllegalStateException("Cannot answer from penalty box");
        }

        boolean isWinningAnswer = isWinningAnswer(userAnswer);
        nextPlayer();
        step = Step.ROLL;
        return isWinningAnswer;
    }

    private boolean isWinningAnswer(int userAnswer) {
        if (userAnswer == dummyAnswer) {
            System.out.println("Question was incorrectly answered");
            System.out.println(player.name + " was sent to the penalty box");
            player.state = PlayerState.State.PENALTY;
            return false;
        } else {
            System.out.println("Answer was correct!!!!");
            player.purse++;
            System.out.println(player.name + " now has " + player.purse + " Gold Coins.");
            return player.purse == WINNING_PURSE;
        }

    }

    public void askQuestion() {
        if (step != Step.QUESTION) {
            throw new IllegalStateException("Cannot ask question at this step");
        }

        WordBank.Theme category = questionCategoryForPlayer(player);
        System.out.println("The category is " + category);
        String question = wordBank.question(category);
        System.out.println(question);
        step = Step.ANSWER;
    }

    private void nextPlayer() {
        int index = players.indexOf(player);
        if (index != (players.size() - 1)) {
            player = players.get(index + 1);
        } else {
            player = players.get(0);
        }
    }

    private WordBank.Theme questionCategoryForPlayer(PlayerState player) {
        return switch (player.place) {
            case 0, 4, 8 -> WordBank.Theme.POP;
            case 1, 5, 9 -> WordBank.Theme.SCIENCE;
            case 2, 6, 10 -> WordBank.Theme.SPORT;
            default -> WordBank.Theme.ROCK;
        };
    }
}
