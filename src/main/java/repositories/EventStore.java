package repositories;

import domain.Booking;
import events.Event;

import java.util.ArrayList;
import java.util.List;

public class EventStore {

    private List<Event> eventList;
    private static EventStore instance;

    private EventStore(){
        eventList = new ArrayList<>();
    }

    public static EventStore getInstance(){
        if(instance == null){
            instance = new EventStore();
        }
        return instance;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
