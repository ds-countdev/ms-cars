package mx.com.cars.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class CarPostRequest {
	
	@Valid
	@NotNull
	@JsonProperty(value = "data")
	private CarPostRequestData request_data;

}
