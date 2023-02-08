package mx.com.cars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

	private String name;

	@JsonProperty(value = "max_velocity")
	private String velocity;

	private String model;
	private String color;
	private String created;

}
