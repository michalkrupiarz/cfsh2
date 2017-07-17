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
				+ "carId INTEGER, foreign key(carId) references cars(id))");
		tables.add("INSERT INTO calendar(dateStart,dateEnd,carId) VALUES('20170110','20170112',1)");
		return tables;
	}
	
	public static List<String> createAndPopulateLendTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE lends (id INTEGER IDENTITY,lendStart VARCHAR(256), lendEnd VARCHAR(256),carId INTEGER,"
				+ "person VARCHAR(2000), foreign key (carId) references cars(id))");
		tables.add("Insert into lends (lendStart,lendEnd,carId,person) "
				+ "values('20170101','20170202',1,'Marcelus Wallace')");
		return tables;
	}
	public static List<String> createAndPopulateRepairsTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE repairs (id INTEGER IDENTITY, dateStart VARCHAR(256), dateEnd VARCHAR(256), "
				+ "carId INTEGER, note VARCHAR(2000), cost decimal (9,2), foreign key (carId) references cars(id))");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('20170202','20170303',1,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('20170202','20170303',1,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('20170202','20170303',2,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('20170202','20170303',2,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('20170202','20170303',1,'To jest pierwsza naprawa',100)");
		return tables;
	}
	public static List<String> createAndPopulateInsuranceTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create Table insurances(id Integer Identity, dateStart VARCHAR(256), dateEnd VARCHAR(256)"
				+ ", note VARCHAR(2000),cost DECIMAL(9,2), insCompany VARCHAR(256)"
				+ ", payDate VARCHAR(256), carId INTEGER"
				+ ", foreign key (carId) references cars(id))");
		tables.add("Insert into insurances (dateStart,dateEnd,note,cost,insCompany,payDate,carId) "
				+ "values('20170202','20180201','ubezpieczenie jeden','1200.21','PZU SA','20170203',1)");
		return tables;
	}
	public static List<String> createAndPopulateTiresTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create table tires (id Integer Identity, type VarChar(256), changeDate VARCHAR(256)"
				+ ", carId INTEGER, foreign key (carId) references cars(id))");
		tables.add("Insert into tires (type,changeDate,carId) "
				+ "values ('zimowe','20170901',1)");
		return tables;
	}
}
