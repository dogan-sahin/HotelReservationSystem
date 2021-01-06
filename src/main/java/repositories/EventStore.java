package repositories;


import aggregates.ReadAggregate;
import events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class EventStore extends Observable {

    private List<Event> eventList;
    private static EventStore instance;
    private ReadAggregate readAggregate;

    private EventStore(){
        eventList = new ArrayList<>();
        readAggregate = new ReadAggregate();
    }

    public static EventStore getInstance(){
        if(instance == null){
            instance = new EventStore();
        }
        return instance;
    }

    public void publish(Event event){
        eventList.add(event);
        readAggregate.update(this, event);
    }

}
