package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repairs")
public class Repair {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="dateStart")
	String dateStart;
	
	@Column(name="dateEnd")
	String dateEnd;
	
	@Column(name="carId")
	int carId;
	
	@Column(name="note")
	String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Repair [id=" + id + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", carId=" + carId + ", note="
				+ note + "]";
	}

	public Repair(int id, String dateStart, String dateEnd, int carId, String note) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.carId = carId;
		this.note = note;
	}

	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
