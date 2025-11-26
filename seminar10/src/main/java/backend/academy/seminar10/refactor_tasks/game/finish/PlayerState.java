package backend.academy.seminar10.refactor_tasks.game;

public class PlayerState {
    final String name;
    int purse;
    int place;
    State state = State.FREE;

    PlayerState(String name) {
        this.name = name;
    }

    enum State {PENALTY, FREE}
}
