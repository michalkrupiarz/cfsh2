
package bean;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.*;

@Entity
@Table(name = "checkouts")
public class Checkout {

int id;
Calendar dateFrom;
Calendar dateTo;
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
@Column(name="dateFrom")
@Temporal(TemporalType.DATE)
public Calendar getDateFrom() {
	return dateFrom;
}

public void setDateFrom(Calendar dateFrom) {
	this.dateFrom = dateFrom;
}
@Column(name="dateTo")
@Temporal(TemporalType.DATE)
public Calendar getDateTo() {
	return dateTo;
}

public void setDateTo(Calendar dateTo) {
	this.dateTo = dateTo;
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

@ManyToOne
@JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false)
@JsonBackReference
public Car getCar() {
	return car;
}

public void setCar(Car car) {
	this.car = car;
}

public Checkout() {
	super();
	// TODO Auto-generated constructor stub
}

public Checkout(int id, Calendar dateFrom, Calendar dateTo, String note, Float cost, Car car) {
	super();
	this.id = id;
	this.dateFrom = dateFrom;
	this.dateTo = dateTo;
	this.note = note;
	this.cost = cost;
	this.car = car;
}


}

