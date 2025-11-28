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
    public void setPurse(int purse) {
        this.purse = purse;
    }
    public int getPlace() {
        return place;
    }
    public void setPlace(int place) {
        this.place = place;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    public enum State {PENALTY, FREE}
}
