package ma.patterndesign.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ObserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Editor editor = new Editor();
		editor.eventJ.subscribe("open", new LoggingListner("/path/to/log/file.txt"));
		editor.eventJ.subscribe("save", new EmailAlertsListener("admin@example.com"));

		try {
			editor.openFile("test.txt");
			editor.saveFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
