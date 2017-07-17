package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="insurances")
public class Insurance {
	int id;
	String dateStart;
	String dateEnd;
	String note;
	Float cost;
	String insCompany;
	String payDate;
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
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	@Column(name="dateEnd")
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
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
	@ManyToOne
    @JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false)
    @JsonBackReference
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Column(name="payDate")
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(int id, String dateStart, String dateEnd, String note, Float cost, String insCompany,
			String payDate, Car car) {
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
