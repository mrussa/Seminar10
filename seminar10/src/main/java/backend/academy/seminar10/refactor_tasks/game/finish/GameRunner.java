package backend.academy.seminar10.refactor_tasks.game;

import java.util.Random;
import java.util.Set;

public class GameRunner {

    private static final int DUMMY_ANSWER = 7;
    private static final int BOUND_ANSWER = 9;

    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 5;

    private static final int QUESTIONS_PER_THEME = 50;

    public static void main(String[] args) {

        Game game = new Game(Set.of("Chet", "Pat", "Sue"), DUMMY_ANSWER, new OneTimeWordBank(QUESTIONS_PER_THEME));

        Random rand = new Random();
        boolean winner = false;
        do {
            boolean hasPenalty = game.roll(rand.nextInt(BOUND_MAX) + BOUND_MIN);
            if (!hasPenalty) {
                game.askQuestion();
                winner = game.answer(rand.nextInt(BOUND_ANSWER));
            }
        } while (!winner);
    }
}
