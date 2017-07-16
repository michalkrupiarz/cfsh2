	package bean;

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

@Entity
@Table(name = "repairs")
public class Repair {

	int id;
	String dateStart;
	String dateEnd;
	String note;
	int carId;
	//private Car car;
	
	
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
	
//    @ManyToOne
//    @JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false)
//	public Car getCar() {
//		return car;
//	}
//
//	public void setCar(Car car) {
//		this.car = car;
//	}
	
	
	
	@Override
	public String toString() {
		return "Repair [id=" + id + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", note="
				+ note + "]";
	}
	
	
//	public int getCarId() {
//		return carId;
//	}
//
//	public void setCarId(int carId) {
//		this.carId = carId;
//	}

	public Repair(int id, String dateStart, String dateEnd, int carId, String note) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.note = note;
	}

	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Repair(int id, String dateStart, String dateEnd, String note, Car car) {
//		super();
//		this.id = id;
//		this.dateStart = dateStart;
//		this.dateEnd = dateEnd;
//		this.note = note;
//		this.car = car;
//	}


	
	
	
}
