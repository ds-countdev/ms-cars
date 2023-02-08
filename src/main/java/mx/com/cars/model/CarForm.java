package mx.com.cars.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
public class CarForm {

	@NotBlank
	@Pattern(regexp = "^([a-zA-Z0-9]+\\s?){3}$")
	private String name;
	
	@NotBlank
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$")
	private String velocity;
	
	@NotBlank
	@Pattern(regexp = "^\\w+(\\s\\w+)?$")
	private String color;
	
	@NotBlank
	@JsonProperty(value = "created_at")
	@Pattern(regexp = "^((?:3[01]|[12][0-9]|0?[1-9])[\\/-]){2}\\d{4}$")
	private String created;
	
}
