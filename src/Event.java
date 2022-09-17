import java.util.Objects;

public class Event {
    private String source;
    private String date;
    private String destination;
    private Action action;
    private ActionState state;

    public Event(String source, String date, String destination, Action action, ActionState state) {
        this.source = source;
        this.date = date;
        this.destination = destination;
        this.action = action;
        this.state = state;
    }

    public String getSource() {
        return source;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public Action getAction() {
        return action;
    }

    public ActionState getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return source.equals(event.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source);
    }

    @Override
    public String toString() {
        return "\nEvent{" +
                "source='" + source + '\'' +
                ", date='" + date + '\'' +
                ", destination='" + destination + '\'' +
                ", action=" + action +
                ", state=" + state +
                "}";
    }
}




