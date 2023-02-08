package mx.com.cars.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long car_id;
	
	@Column(name = "name", length = 50 , nullable = false)
	private String name;
	
	@Column(name = "max_velocity", length = 10 , nullable = false)
	private Double velocity;
	
	@Column(name = "model" , length = 50)
	private String model;
	
	@Column(name = "color", length = 20)
	private String color;
	
	@Column(name = "active" , nullable = false)
	private Boolean active;

	@Column(name = "create_at" , nullable = true)
	private LocalDate created;
	
	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	
}
