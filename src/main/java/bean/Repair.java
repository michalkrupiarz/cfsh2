	package bean;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.*;

@Entity
@Table(name = "repairs")
public class Repair {

	int id;
	Calendar dateStart;
	Calendar dateEnd;
	String note;
	Float cost;
	private Car car;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="dateStart")
	@Temporal(TemporalType.DATE)
	public Calendar getDateStart() {
		return dateStart;
	}
	
	public void setDateStart(Calendar dateStart) {
		this.dateStart = dateStart;
	}
	
	@Column(name="dateEnd")
	@Temporal(TemporalType.DATE)
	public Calendar getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Calendar dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	
	@Column(name="note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name="cost")
    public Float getCost() {	
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false		)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	public Car getCar() {	
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
