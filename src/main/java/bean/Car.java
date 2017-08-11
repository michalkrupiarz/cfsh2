	package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Check;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.*;


@Entity
@Transactional
@Table(name="cars")

public class Car{
	int id;
	String carName;
	String carRegistration;
	//private List<Repair> repairs = new ArrayList<Repair>(0);
	private List<Repair> repairs = new ArrayList<>();
	private List<carLend> lends = new ArrayList<>();
	private List<Insurance> insurances = new ArrayList<>();
	private List<Tire> tires = new ArrayList<>(0);
	private List<Document> doc = new ArrayList<>();
	private List<Checkout> check = new ArrayList<>();
	
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
	
	@Transactional
	@OneToMany(targetEntity= Repair.class, fetch = FetchType.LAZY , mappedBy="car",cascade = CascadeType.REMOVE)
	//@Cascade({org.hibernate.annotations.CascadeType.ALL}) 
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties(value = {"car"}, allowSetters = true)
	public List<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(List<Repair> repairs) {
		this.repairs= repairs;
	}
	
	@OneToMany(targetEntity = carLend.class, fetch = FetchType.LAZY, mappedBy = "car",cascade = CascadeType.REMOVE)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties(value = {"car"}, allowSetters = true)
	public List<carLend> getLends() {
		return lends;
	}
	public void setLends(List<carLend> lends) {
		this.lends = lends;
	}
	
	@OneToMany(targetEntity = Insurance.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.REMOVE)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	@JsonIgnoreProperties(value = {"car"}, allowSetters = true)
	public List<Insurance> getInsurances() {
		return insurances;
	}
	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(targetEntity = Tire.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	@JsonIgnoreProperties("car")
	public List<Tire> getTires() {
		return tires;
	}
	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}
	@OneToMany(targetEntity = Document.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	@JsonIgnoreProperties("car")
	public List<Document> getDoc() {
		return doc;
	}
	public void setDoc(List<Document> doc) {
		this.doc = doc;
	}
	@OneToMany(targetEntity = Checkout.class, fetch = FetchType.LAZY, mappedBy = "car",cascade=CascadeType.ALL)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")	
	@JsonIgnoreProperties(value = {"car"}, allowSetters = true)
	public List<Checkout> getCheck() {
		return check;
	}
	public void setCheck(List<Checkout> check) {
		this.check = check;
	}
	
	public void addRepair(Repair rep) {
		rep.setCar(this);
	}
	
	

}
