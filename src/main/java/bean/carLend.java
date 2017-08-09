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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="lends")
public class carLend {

	
	int id;
	
	
	Calendar lendStart;
	
	
	Calendar lendEnd;
		
	
	String person;
	
	
	private Car car;
	
	
	private Status status;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
    @JoinColumn(name = "carId", updatable = true, insertable =true, nullable=false		)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties(value = {"lends"}, allowSetters = true)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="lendStart")
	@Temporal(TemporalType.DATE)
	public Calendar getLendStart() {
		return lendStart;
	}

	public void setLendStart(Calendar lendStart) {
		this.lendStart = lendStart;
	}
	@Column(name="lendEnd")
	@Temporal(TemporalType.DATE)
	public Calendar getLendEnd() {
		return lendEnd;
	}

	public void setLendEnd(Calendar lendEnd) {
		this.lendEnd = lendEnd;
	}
	@Column(name="person")
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="statusId",updatable=true, insertable=true,nullable=false)
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIgnoreProperties("status")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public carLend(){
		super();
	}

	public carLend(int id, Calendar lendStart, Calendar lendEnd, String person, Car car, Status status) {
		super();
		this.id = id;
		this.lendStart = lendStart;
		this.lendEnd = lendEnd;
		this.person = person;
		this.car = car;
		this.status = status;
	}

	
	
}
