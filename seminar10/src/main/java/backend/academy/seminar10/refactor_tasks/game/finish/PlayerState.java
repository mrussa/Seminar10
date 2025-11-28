package backend.academy.seminar10.refactor_tasks.game;

public class PlayerState {
    private final String name;
    private int purse;
    private int place;
    private State state = State.FREE;

    public PlayerState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPurse() {
        return purse;
    }

    public int getPlace() {
        return place;
    }

    public State getState() {
        return state;
    }

    public void move(int steps, int boardSize) {
        place = (place + steps) % boardSize;
    }

    public void addCoin() {
        purse++;
    }

    public void sendToPenalty() {
        state = State.PENALTY;
    }

    public void releaseFromPenalty() {
        state = State.FREE;
    }

    public enum State {PENALTY, FREE}
}
