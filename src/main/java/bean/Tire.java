package bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tires")
public class Tire {


	int id;

	String type;
	
	Calendar changeDate;
	
	private Car car;
	
	@JsonIgnoreProperties("status")
	private Status status;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(name="changeDate")
	@Temporal(TemporalType.DATE)
	public Calendar getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Calendar changeDate) {
		this.changeDate = changeDate;
	}
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
    @JoinColumn(name = "carId", updatable = true, insertable = true, nullable=false		)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties(value = {"tires"},allowSetters = true)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="statusId",updatable=true, insertable=true,nullable=false)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties(value = {"status"}, allowSetters = true)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
		
	public Tire(int id, String type, Calendar changeDate, Car car, Status status) {
		super();
		this.id = id;
		this.type = type;
		this.changeDate = changeDate;
		this.car = car;
		this.status = status;
	}

	public Tire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}