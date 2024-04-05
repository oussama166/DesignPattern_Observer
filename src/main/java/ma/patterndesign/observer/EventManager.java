package ma.patterndesign.observer;

import java.io.File;
import java.util.*;

public class EventManager {
    Map<String, List<EventListner>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListner listener) {
        List<EventListner> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListner> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListner> users = listeners.get(eventType);
        for (EventListner listener : users) {
            listener.update(eventType, file);
        }
    }


}
