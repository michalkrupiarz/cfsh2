package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lends")
public class carLend {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="lendStart")
	String lendStart;
	
	@Column(name="lendEnd")
	String lendEnd;
	
	@Column(name="carId")
	int carId;
	
	@Column(name="person")
	String person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLendStart() {
		return lendStart;
	}

	public void setLendStart(String lendStart) {
		this.lendStart = lendStart;
	}

	public String getLendEnd() {
		return lendEnd;
	}

	public void setLendEnd(String lendEnd) {
		this.lendEnd = lendEnd;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "carLend [id=" + id + ", lendStart=" + lendStart + ", lendEnd=" + lendEnd + ", carId=" + carId
				+ ", person=" + person + "]";
	}

	public carLend(){
		super();
	}
	
	public carLend(int id, String lendStart, String lendEnd, int carId, String person) {
		super();
		this.id = id;
		this.lendStart = lendStart;
		this.lendEnd = lendEnd;
		this.carId = carId;
		this.person = person;
	}
	
}
