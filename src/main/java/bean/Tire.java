package bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tires")
public class Tire {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="type")
	String type;
	
	@Column(name="changeDate")
	@Temporal(TemporalType.DATE)
	Calendar changeDate;
	
	@ManyToOne
    @JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false)
    @JsonBackReference
	private Car car;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Calendar getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Calendar changeDate) {
		this.changeDate = changeDate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Tire(int id, String type, Calendar changeDate, Car car) {
		super();
		this.id = id;
		this.type = type;
		this.changeDate = changeDate;
		this.car = car;
	}

	public Tire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}