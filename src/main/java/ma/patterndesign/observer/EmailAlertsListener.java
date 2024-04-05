package ma.patterndesign.observer;

import java.io.File;

public class EmailAlertsListener implements EventListner {
    private String email;

    public EmailAlertsListener(String Email){
        this.email = Email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Email to %s Someone has performed operation %s with the following file: %s\n",this.email,eventType,file.getName());
    }
}
