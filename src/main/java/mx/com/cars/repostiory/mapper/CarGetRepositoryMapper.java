package mx.com.cars.repostiory.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import mx.com.cars.model.CarModel;
import mx.com.cars.repository.entity.Car;

@Component
public class CarGetRepositoryMapper {

	public CarModel car_entity_to_car_model(Car car_entity) {
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		return car_entity != null
				? new CarModel(car_entity.getName(), car_entity.getVelocity().toString().concat(" km/h"),
						car_entity.getModel(), car_entity.getColor().toUpperCase(),
						date_format.format(LocalDate.parse(car_entity.getCreated().toString())).toString())
				: null;
	}
}
