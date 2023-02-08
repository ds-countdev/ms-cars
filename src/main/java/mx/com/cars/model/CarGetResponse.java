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
public class CarGetResponse {
	
	private Status status;
	
	@JsonProperty(value = "data")
	private CarGetResponseData car_get_response_data;

}
