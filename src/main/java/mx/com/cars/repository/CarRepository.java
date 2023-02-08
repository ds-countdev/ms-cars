package mx.com.cars.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.cars.repository.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	@Transactional(readOnly = true)
	@Query(value = "select * from cars c where c.car_id = :car_id", nativeQuery = true)
	public Optional<Car> find_car_by_id(@Param("car_id") Long car_id);
}
