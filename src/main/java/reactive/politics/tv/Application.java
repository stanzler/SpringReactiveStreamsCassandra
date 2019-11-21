package reactive.politics.tv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactive.politics.tv.webclient.PoliticsUserDataWebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	PoliticsUserDataWebClient pdwc = new PoliticsUserDataWebClient();
	System.out.println(pdwc.getResult());
	}

}
