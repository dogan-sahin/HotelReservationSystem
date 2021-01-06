package events;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final LocalDate created = LocalDate.now();

    public LocalDate getCreated() {
        return created;
    }
}


