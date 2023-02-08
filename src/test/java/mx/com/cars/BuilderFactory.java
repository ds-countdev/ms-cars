package mx.com.cars;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mx.com.cars.config.model.property.ServiceMessages;
import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarGetResponseData;
import mx.com.cars.model.CarModel;
import mx.com.cars.model.Status;
import mx.com.cars.repository.entity.Agency;
import mx.com.cars.repository.entity.Car;

public class BuilderFactory {
	
	public static ServiceMessages create_service_messages() {
		return new ServiceMessages("Succesful search",null, null);
	}
	
	public static Optional<Car> create_car_entity(){
	   return Optional.of(new Car(1L, "Ferrari 408", 340.00, "408", "red", true, LocalDate.of(2015, 02, 03),
			   new Agency(1L,"Ferrari",null)));
	}

	public static Optional<Car> get_car_entity(){
		return Optional.of(new Car(1L,"Ferrari 408",340.00,"408","red",true,LocalDate.of(2015, 02, 03),
				new Agency(1L,"Ferrari",null)));
	}
	
	public static ResponseEntity<CarGetResponse> get_car_standard_response(){
		Status status = new Status(200, "Succesful search");
		CarGetResponseData data = new CarGetResponseData(get_car_model());
		CarGetResponse get_response = new CarGetResponse(status,data);
		return ResponseEntity.status(HttpStatus.OK).body(get_response);
	}
	
	public static CarModel get_car_model(){
		return new CarModel("Ferrari 408","340.0 km/h","408","RED","03/02/2015");
	}
}
