package bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="insurances")
public class Insurance {
	int id;
	Calendar dateStart;
	Calendar dateEnd;
	String note;
	Float cost;
	String insCompany;
	Calendar payDate;
	private Car car;
	
	
	@Id
	@Column(name="id")
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
	@Column(name="insCompany")
	public String getInsCompany() {
		return insCompany;
	}
	public void setInsCompany(String insCompany) {
		this.insCompany = insCompany;
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
	@Column(name="payDate")
	@Temporal(TemporalType.DATE)
	public Calendar getPayDate() {
		return payDate;
	}
	public void setPayDate(Calendar payDate) {
		this.payDate = payDate;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(int id, Calendar dateStart, Calendar dateEnd, String note, Float cost, String insCompany,
			Calendar payDate, Car car) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.note = note;
		this.cost = cost;
		this.insCompany = insCompany;
		this.payDate = payDate;
		this.car = car;
	}


	
}
