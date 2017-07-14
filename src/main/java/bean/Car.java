package bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cars")
public class Car {
	

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="carName")
	String carName;
	
	@Column (name="carRegistration")
	String carRegistration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarRegistration() {
		return carRegistration;
	}
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int id, String carName, String carRegistration) {
		super();
		this.id = id;
		this.carName = carName;
		this.carRegistration = carRegistration;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carRegistration=" + carRegistration + "]";
	}
	
	

	
}
