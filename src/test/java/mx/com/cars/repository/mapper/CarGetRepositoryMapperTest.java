package mx.com.cars.repository.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cars.BuilderFactory;
import mx.com.cars.model.CarModel;
import mx.com.cars.repostiory.mapper.CarGetRepositoryMapper;

@ExtendWith(MockitoExtension.class)
class CarGetRepositoryMapperTest {

	private static final Logger LOG = LoggerFactory.getLogger(CarGetRepositoryMapperTest.class);
	private static CarGetRepositoryMapper car_get_repository_mapper;

	@BeforeAll
	static void init() {
		car_get_repository_mapper = new CarGetRepositoryMapper();
	}

	@Test
	@DisplayName("car_entity_to_car_model")
	void test_for_car_entity_to_car_model_when_car_has_data() {
		CarModel car = car_get_repository_mapper.car_entity_to_car_model(BuilderFactory.get_car_entity().get());
		LOG.info("HELLO THERE");
		assertAll(() -> assertEquals("Ferrari 408", car.getName()), () -> assertEquals("RED", car.getColor()),
				() -> assertEquals("488", car.getModel()),
				() -> assertEquals("03/02/2015", car.getCreated().toString()),
				() -> assertEquals("340.0 km/h", car.getVelocity()));
	}

	@Test
	@DisplayName("car_entity_to_car_model_2")
	void test_for_car_entity_to_car_model_when_car_is_null() {
		CarModel car = car_get_repository_mapper.car_entity_to_car_model(null);
		assertNull(car);
	}

	@AfterAll
	static void finish() {
		car_get_repository_mapper = null;
	}

}
