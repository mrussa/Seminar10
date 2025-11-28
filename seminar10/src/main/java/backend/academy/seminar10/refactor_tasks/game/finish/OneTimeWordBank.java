package backend.academy.seminar10.refactor_tasks.game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Map;

public class OneTimeWordBank implements WordBank {

    private final Map<Theme, Deque<String>> questionsByTheme = new EnumMap<>(Theme.class);

    public OneTimeWordBank(int questionsPerTheme) {
        questionsByTheme.put(Theme.POP, new ArrayDeque<>());
        questionsByTheme.put(Theme.SCIENCE, new ArrayDeque<>());
        questionsByTheme.put(Theme.SPORT, new ArrayDeque<>());
        questionsByTheme.put(Theme.ROCK, new ArrayDeque<>());

        for (int i = 0; i < questionsPerTheme; i++) {
            questionsByTheme.get(Theme.POP).addLast("Pop Question " + i);
            questionsByTheme.get(Theme.SCIENCE).addLast("Science Question " + i);
            questionsByTheme.get(Theme.SPORT).addLast("Sports Question " + i);
            questionsByTheme.get(Theme.ROCK).addLast("Rock Question " + i);
        }
    }

    @Override
    public String question(Theme theme) {
            Deque<String> questions = questionsByTheme.get(theme);
            if (questions == null || questions.isEmpty()) {
                throw new IllegalStateException("no more questions for theme " + theme);
            }
            return questions.removeFirst();
        }
}
