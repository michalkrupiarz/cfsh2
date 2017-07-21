	package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.*;


@Entity
@Table(name="cars")
public class Car{
	int id;
	String carName;
	String carRegistration;
	private Set<Repair> repairs = new HashSet<Repair>(0);
	private Set<carLend> lends = new HashSet<carLend>(0);
	private Set<Insurance> insurances = new HashSet<Insurance>(0);
	private Set<Tire> tires = new HashSet<Tire>(0);
	private Set<Document> doc = new HashSet<Document>(0);
	private Set<Checkout> check = new HashSet<Checkout>(0);
	
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
	
	@OneToMany(targetEntity= Repair.class, fetch = FetchType.LAZY , mappedBy="car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	public Set<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(Set<Repair> repairs) {
		this.repairs= repairs;
	}
	
	@OneToMany(targetEntity = carLend.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	public Set<carLend> getLends() {
		return lends;
	}
	public void setLends(Set<carLend> lends) {
		this.lends = lends;
	}
	
	@OneToMany(targetEntity = Insurance.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	public Set<Insurance> getInsurances() {
		return insurances;
	}
	public void setInsurances(Set<Insurance> insurances) {
		this.insurances = insurances;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(targetEntity = Tire.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	public Set<Tire> getTires() {
		return tires;
	}
	public void setTires(Set<Tire> tires) {
		this.tires = tires;
	}
	@OneToMany(targetEntity = Document.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	public Set<Document> getDoc() {
		return doc;
	}
	public void setDoc(Set<Document> doc) {
		this.doc = doc;
	}
	@OneToMany(targetEntity = Checkout.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	public Set<Checkout> getCheck() {
		return check;
	}
	public void setCheck(Set<Checkout> check) {
		this.check = check;
	}
	
	

}
