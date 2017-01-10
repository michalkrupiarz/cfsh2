package hsqlServer;

import java.util.ArrayList;
import java.util.List;

public class createTablesHelper {
	
	public static List<String> createAndPopulateCarsTable(){
		
		List<String> tables = new ArrayList<String>();
		
		tables.add("CREATE TABLE cars (id INTEGER IDENTITY, carName VARCHAR(256), carRegistration VARCHAR(256))");
		tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Ford', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Toyota', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Honda', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('GM', 'AXX100')");
		
		return tables;
	}
	
	public static List<String> createAndPopulateCalendarTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE calendar(id INTEGER IDENTITY, dateStart VARCHAR(256), dateEnd VARCHAR(256),"
				+ "carId INTEGER, foreign key(carID) references cars(id)");
		tables.add("INSERT INTO calendar(dateStart,dateEnd,carId) VALUES('20170110','20170112',1)");
		return tables;
	}
}
