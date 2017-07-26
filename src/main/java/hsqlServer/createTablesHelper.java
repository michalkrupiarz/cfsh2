	package hsqlServer;

import java.util.ArrayList;
import java.util.List;

public class createTablesHelper {
	
	public static List<String> createAndPopulateCarsTable(){
		
		List<String> tables = new ArrayList<String>();
		
		tables.add("CREATE TABLE cars (id SERIAL primary key, carName VARCHAR(256), carRegistration VARCHAR(256))");
		tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Ford', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Toyota', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('Honda', 'AXX100')");
	    tables.add("INSERT INTO cars(carName,carRegistration) VALUES('GM', 'AXX100')");
		
		return tables;
	}
	
	public static List<String> createAndPopulateCalendarTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE calendar(id SERIAL primary key, dateStart date, dateEnd date,"
				+ "carId INTEGER, statusId INTEGER, foreign key(carId) references cars(id), "
				+ "foreign key(statusId) references status(id))");
		tables.add("INSERT INTO calendar(dateStart,dateEnd,carId,statusId)"
				+ " VALUES('2017-01-10','2017-01-12',1,2)");
		return tables;
	}
	
	public static List<String> createAndPopulateLendTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE lends (id SERIAL primary key,lendStart timestamp, lendEnd timestamp,carId INTEGER,"
				+ "person VARCHAR(2000), statusId INTEGER, foreign key (carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into lends (lendStart,lendEnd,carId,person,statusId) "
				+ "values('2017-01-01 08:00:00','2017-02-02 16:00:00',1,'Marcelus Wallace',2)");
		return tables;
	}
	public static List<String> createAndPopulateRepairsTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("CREATE TABLE repairs (id SERIAL primary key, dateStart DATE, dateEnd DATE, "
				+ "carId INTEGER, note VARCHAR(2000), cost decimal (9,2), statusId INTEGER,foreign key (carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-01','2017-07-10',1,'To jest pierwsza naprawa',100,2)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-10','2017-07-14',3,'To jest pierwsza naprawa',100,2)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-12','2017-07-21',2,'To jest pierwsza naprawa',100,2)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-15','2017-07-24',2,'To jest pierwsza naprawa',100,2)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-17','2017-07-30',4,'To jest pierwsza naprawa',100,2)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-01','2017-07-10',3,'To jest pierwsza naprawa',100,1)");
		tables.add("Insert into repairs(dateStart,dateEnd,carId,note,cost,statusId) "
				+ "values('2017-07-01','2017-07-10',3,'To jest pierwsza naprawa',100,3)");
		return tables;
	}
	public static List<String> createAndPopulateInsuranceTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create Table insurances(id SERIAL primary key, dateStart date, dateEnd date"
				+ ", note VARCHAR(2000),cost DECIMAL(9,2), insCompany VARCHAR(256)"
				+ ", payDate date, carId INTEGER,"
				+ "statusId INTEGER,"
				+ "foreign key (carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into insurances (dateStart,dateEnd,note,cost,insCompany,payDate,carId,statusId) "
				+ "values('2017-02-02','2018-02-01','ubezpieczenie jeden','1200.21','PZU SA','2017-02-03',1,2)");
		return tables;
	}
	public static List<String> createAndPopulateTiresTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("Create table tires (id SERIAL primary key, type VarChar(256), changeDate date"
				+ ", carId INTEGER, statusId INTEGER,foreign key (carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into tires (type,changeDate,carId,statusId) "
				+ "values ('zimowe','2017-09-01',1,2)");
		return tables;
	}
	public static List<String> createAndPopulateDocumentTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("create table documents (id SERIAL primary key, type VarChar(256), expirationDate date,"
				+ "carId Integer, statusId INTEGER,foreign key(carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into documents (type, expirationDate,carId,statusId) "
				+ "values ('wymiana dowod','2022-05-12',2,2)");
		return tables;
	}
	public static List <String> createAndPopulateCheckoutTable(){
		List<String> tables = new ArrayList<String>();
		tables.add("create table checkouts (id SERIAL primary key, dateFrom date,"
				+ "dateTo date, note varChar(256),cost decimal(9,2), carId Integer,statusId INTEGER, "
				+ "foreign key (carId) references cars(id)"
				+ ",foreign key(statusId) references status(id))");
		tables.add("Insert into checkouts(dateFrom,dateTo,note,cost,carId,statusId)"
				+ " values ('2017-07-01','2018-06-30','wykonano, wszystko ok','100.00',3,2)");
		return tables;
	}
	
	public static List<String> createAndPopulateStatusTable(){
		List<String> t = new ArrayList<String>();
		t.add("create table status (id SERIAL primary key, progress VARCHAR(256))");
		t.add("insert into status (progress) values('new')");
		t.add("insert into status (progress) values('in status')");
		t.add("insert into status (progress) values('done')");
		return t;
	}
}
