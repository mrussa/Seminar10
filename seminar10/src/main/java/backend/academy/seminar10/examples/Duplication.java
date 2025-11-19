package backend.academy.seminar10.examples;

import java.math.BigDecimal;

public class Duplication {

}
class TaskWeightCalculator {
    public int calculate(Task task) {
        if (task.isBug()) {
            int value = task.getPriority() * 4;
            int adjusted = value - task.getComplexity();
            if (adjusted < 0) adjusted = 0;
            return adjusted;
        } else {
            int value = task.getPriority() * 4;
            int adjusted = value - task.getComplexity();
            if (adjusted < 0) adjusted = 0;
            return adjusted + 2; // Дополнительный вес
        }
    }
}



class TaskWeightCalculatorAfter {
    public int calculate(Task task) {
        int base = computeBase(task);

        if (task.isBug()) {
            return base;
        } else {
            return base + 2;
        }
    }

    private int computeBase(Task task) {
        int value = task.getPriority() * 4;
        int adjusted = value - task.getComplexity();
        return Math.max(adjusted, 0);
    }
}

class Task {

    private final int priority;
    private final int complexity;
    private final boolean bug;

    public Task(int priority, int complexity, boolean bug) {
        this.priority = priority;
        this.complexity = complexity;
        this.bug = bug;
    }

    public int getPriority() {
        return priority;
    }

    public int getComplexity() {
        return complexity;
    }

    public boolean isBug() {
        return bug;
    }
}
