package bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cars")
public class Car {
	int id;
	String carName;
	String carRegistration;
	private Set<Repair> repairs = new HashSet<Repair>(0);
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="carName")
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	@Column (name="carRegistration")
	public String getCarRegistration() {
		return carRegistration;
	}
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="car")
	public Set<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(Set<Repair> repairs) {
		this.repairs= repairs;
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
	
	
	
	public Car(int id, String carName, String carRegistration, Set<Repair> repairs) {
		super();
		this.id = id;
		this.carName = carName;
		this.carRegistration = carRegistration;
		this.repairs = repairs;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carRegistration=" + carRegistration + "]";
	}
	
	

	
}
