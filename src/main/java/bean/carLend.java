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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="lends")
public class carLend {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="lendStart")
	@Temporal(TemporalType.DATE)
	Calendar lendStart;
	
	@Column(name="lendEnd")
	@Temporal(TemporalType.DATE)
	Calendar lendEnd;
		
	@Column(name="person")
	String person;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "carId", updatable = false, insertable = false, nullable=false		)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Car car;
	
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getLendStart() {
		return lendStart;
	}

	public void setLendStart(Calendar lendStart) {
		this.lendStart = lendStart;
	}

	public Calendar getLendEnd() {
		return lendEnd;
	}

	public void setLendEnd(Calendar lendEnd) {
		this.lendEnd = lendEnd;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

//	@Override
//	public String toString() {
//		return "carLend [id=" + id + ", lendStart=" + lendStart + ", lendEnd=" + lendEnd + ", carId=" + carId
//				+ ", person=" + person + "]";
//	}

	public carLend(){
		super();
	}
	
	public carLend(int id, Calendar lendStart, Calendar lendEnd, int carId, String person) {
		super();
		this.id = id;
		this.lendStart = lendStart;
		this.lendEnd = lendEnd;
		this.person = person;
	}
	
}
