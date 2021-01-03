package repositories;

import aggregates.ReadAggregate;
import domain.Booking;
import events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventStore extends Observable {

    private List<Event> eventList;
    private List<Observer> subscribers;
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

    public void subscribe(Observer o){
        subscribers.add(o);
    }

    public void publish(Event event){
        eventList.add(event);
        for(Observer o : subscribers){
            notifyObservers(event);
        }
    }


    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
