package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="documents")
public class Document {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name = "type")
	String type;
	@Column(name="expirationDate")
	String expirationDate;
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
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Document(int id, String type, String expirationDate, Car car) {
		super();
		this.id = id;
		this.type = type;
		this.expirationDate = expirationDate;
		this.car = car;
	}
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
