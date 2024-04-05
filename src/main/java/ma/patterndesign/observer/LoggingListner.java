package ma.patterndesign.observer;

import java.io.File;

public class LoggingListner implements EventListner {
    public File log;
    public LoggingListner(String fileName){
        log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Save to log %s Someone has performed %s operation with the file %s\n",log,eventType,file.getName());
    }
}
