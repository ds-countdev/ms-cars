package mx.com.cars.repository.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agency")
public class Agency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long agency_id;

	@Column(name = "agency_name", nullable = false, unique = true, length = 100)
	private String name;

	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Car> cars;

}
