package repositories;


import aggregates.ReadAggregate;
import events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventStore extends Observable {

    private List<Event> eventList;
    private List<Observer> subscribers;
    private static EventStore instance;
    private ReadAggregate readAggregate;

    private EventStore(){
        eventList = new ArrayList<>();
        subscribers = new ArrayList<>();
        readAggregate = new ReadAggregate();
        subscribers.add(readAggregate);
    }

    public static EventStore getInstance(){
        if(instance == null){
            instance = new EventStore();
        }
        return instance;
    }

    public void publish(Event event){
        eventList.add(event);
        for(Observer o : subscribers){
            notifyObservers(event);
        }
    }

}
