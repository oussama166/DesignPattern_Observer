package ma.patterndesign.observer;

import java.io.File;

public interface EventListner {
    void update(String eventType, File file);
}
