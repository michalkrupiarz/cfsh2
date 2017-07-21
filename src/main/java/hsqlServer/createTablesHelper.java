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
		tables.add("CREATE TABLE calendar(id INTEGER IDENTITY, dateStart date, dateEnd date,"
				+ "carId INTEGER, foreign key(carId) references cars(id))");
		tables.add("INSERT INTO calendar(dateStart,dateEnd,carId) VALUES('2017-01-10','2017-01-12',1)");
		return tables;
	}
	
	public static List<String> createAndPopulateLendTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE lends (id INTEGER IDENTITY,lendStart DateTime, lendEnd DateTime,carId INTEGER,"
				+ "person VARCHAR(2000), foreign key (carId) references cars(id))");
		tables.add("Insert into lends (lendStart,lendEnd,carId,person) "
				+ "values('2017-01-01 08:00:00','2017-02-02 16:00:00',1,'Marcelus Wallace')");
		return tables;
	}
	public static List<String> createAndPopulateRepairsTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE repairs (id INTEGER IDENTITY, dateStart DATE, dateEnd DATE, "
				+ "carId INTEGER, note VARCHAR(2000), cost decimal (9,2), foreign key (carId) references cars(id))");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('2017-07-01','2017-07-10',1,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('2017-07-10','2017-07-14',1,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('2017-07-12','2017-07-21',2,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('2017-07-15','2017-07-24',2,'To jest pierwsza naprawa',100)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost) "
				+ "values('2017-07-17','2017-07-30',1,'To jest pierwsza naprawa',100)");
		return tables;
	}
	public static List<String> createAndPopulateInsuranceTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create Table insurances(id Integer Identity, dateStart date, dateEnd date"
				+ ", note VARCHAR(2000),cost DECIMAL(9,2), insCompany VARCHAR(256)"
				+ ", payDate date, carId INTEGER"
				+ ", foreign key (carId) references cars(id))");
		tables.add("Insert into insurances (dateStart,dateEnd,note,cost,insCompany,payDate,carId) "
				+ "values('2017-02-02','2018-02-01','ubezpieczenie jeden','1200.21','PZU SA','2017-02-03',1)");
		return tables;
	}
	public static List<String> createAndPopulateTiresTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create table tires (id Integer Identity, type VarChar(256), changeDate date"
				+ ", carId INTEGER, foreign key (carId) references cars(id))");
		tables.add("Insert into tires (type,changeDate,carId) "
				+ "values ('zimowe','2017-09-01',1)");
		return tables;
	}
	public static List<String> createAndPopulateDocumentTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("create table documents (id Integer Identity, type VarChar(256), expirationDate date,"
				+ "carId Integer, foreign key(carId) references cars(id))");
		tables.add("Insert into documents (type, expirationDate,carId) "
				+ "values ('wymiana dowod','2022-05-12',2)");
		return tables;
	}
	public static List <String> createAndPopulateCheckoutTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("create table checkouts (id Integer Identity, dateFrom date,"
				+ "dateTo date, note varChar(256),cost decimal(9,2), carId Integer, "
				+ "foreign key (carId) references cars(id))");
		tables.add("Insert into checkouts(dateFrom,dateTo,note,cost,carId)"
				+ " values ('2017-07-01','2018-06-30','wykonano, wszystko ok','100.00',3)");
		return tables;
	}
}
