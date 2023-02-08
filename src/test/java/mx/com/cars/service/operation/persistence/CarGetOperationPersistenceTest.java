package mx.com.cars.service.operation.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import mx.com.cars.BuilderFactory;
import mx.com.cars.model.CarModel;
import mx.com.cars.repository.CarRepository;
import mx.com.cars.repostiory.mapper.CarGetRepositoryMapper;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CarGetOperationPersistenceTest {

	@InjectMocks
	private CarGetOperationPersistence car_get_operation_persistence;

	@Mock
	private CarRepository car_repository;

	@Mock
	private CarGetRepositoryMapper car_get_repository_mapper;

	@Test
	@DisplayName("operation_persistence_1")
	void test_for_operation_persistence_1() {
		when(car_repository.find_car_by_id(1L)).thenReturn(BuilderFactory.create_car_entity());
		when(car_get_repository_mapper.car_entity_to_car_model(BuilderFactory.create_car_entity().orElseThrow(null)))
				.thenReturn(BuilderFactory.get_car_model());

		CarModel car_model = car_get_operation_persistence.car_get_persistence(1L);
		assertAll(() -> assertNotNull(car_model), () -> assertEquals("Ferrari 408", car_model.getName()),
				() -> assertEquals("RED", car_model.getColor()), () -> assertEquals("480", car_model.getModel()),
				() -> assertEquals("03/02/2015", car_model.getCreated().toString()),
				() -> assertEquals("340.0 km/h", car_model.getVelocity()));

	}

	@Test
	@DisplayName("operation_persistence_2")
	void test_for_operation_persistence_2() {
		when(car_repository.find_car_by_id(1L)).thenReturn(null);
		when(car_get_repository_mapper.car_entity_to_car_model(null)).thenReturn(null);

		CarModel car_model = car_get_operation_persistence.car_get_persistence(1000L);
		assertNull(car_model);
	}

};