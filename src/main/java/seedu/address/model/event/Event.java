package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents an Event in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Event {
    private final EventName eventName;
    private final Description description;
    private final AttendeesList attendeesList = new AttendeesList();

    /**
     * Every field must be present and not null.
     */
    public Event(EventName eventName, Description description) {
        requireAllNonNull(eventName, description);
        this.eventName = eventName;
        this.description = description;
    }

    public EventName getName() {
        return eventName;
    }

    public Description getDescription() {
        return description;
    }

    public AttendeesList getAttendeesList() {
        return attendeesList;
    }

    /**
     * Returns true if both events have the same name and description.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getName().equals(getName())
                && otherEvent.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both events have the same name and description.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return otherEvent.getName().equals(getName())
                && otherEvent.getDescription().equals(getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, description, attendeesList);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Description: ")
                .append(getDescription());
        return builder.toString();
    }
}
