package mx.com.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import mx.com.cars.config.model.property.ServiceMessages;
import mx.com.cars.config.model.property.StatusMessages;
import mx.com.errors.handler.controller.ErrorHandlerController;
import mx.com.errors.handler.model.MessageProperties;
import mx.com.errors.handler.util.Utilities;

@SpringBootApplication
@Import(value = {ErrorHandlerController.class, Utilities.class, MessageProperties.class})
public class MsCarsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MsCarsApplication.class, args);
	}

	@Autowired
	private ServiceMessages messages;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hello");
		System.out.println(messages.getTest());
	}

}
