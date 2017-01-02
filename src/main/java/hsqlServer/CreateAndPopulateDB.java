package hsqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Car;


public class CreateAndPopulateDB {
	static Connection conn;
	public CreateAndPopulateDB() throws Exception {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		conn = DriverManager.getConnection("jdbc:hsqldb:C:/hsqldb-2.3.4/baza4","SA","");
	}
	public void shutdown() throws SQLException {

        Statement st = conn.createStatement();

        // db writes out to files and performs clean shuts down
        // otherwise there will be an unclean shutdown
        // when program ends
        st.execute("SHUTDOWN");
        conn.close();    // if there are no other open connection
    }
	
	
	public static synchronized void update(String querry) throws SQLException{
		Statement st = null;
		System.out.println("XXX Executing querry XXX "+querry);
        st = conn.createStatement();    // statements
        
        int i = st.executeUpdate(querry);    // run the query

        if (i == -1) {
            System.out.println("db error : " + querry);
        }

        
        //st.execute("SHUTDOWN");
        st.close();
        
    }
	
	
	public static void checkOrCreateTable(CreateAndPopulateDB db) throws Exception{
		System.out.println("XXX Weszlo do generowania danych");
		try {
			db.update("CREATE TABLE cars (id INTEGER IDENTITY, carName VARCHAR(256), carRegistration VARCHAR(256))");
			db.update(
	                "INSERT INTO cars(carName,carRegistration) VALUES('Ford', 'AXX100')");
	            db.update(
	                "INSERT INTO cars(carName,carRegistration) VALUES('Toyota', 'AXX100')");
	            db.update(
	                "INSERT INTO cars(carName,carRegistration) VALUES('Honda', 'AXX100')");
	            db.update(
	                "INSERT INTO cars(carName,carRegistration) VALUES('GM', 'AXX100')");
		} catch (SQLException ex2) {
			//db.shutdown();
        	System.out.println("Exception from try catch i checkOrCreateTable "+ex2);
        	List<Car> cars = new ArrayList<>();
        	cars = getAllCars("select * from cars");
        	for (Car car:cars){
        		System.out.println(car.getId()+car.getCarName()+car.getCarRegistration());
        	}
        }		
		List<Car> cars = new ArrayList<>();
    	cars = getAllCars("select * from cars");
    	for (Car car:cars){
    		System.out.println(car.getId()+car.getCarName()+car.getCarRegistration());
    	}
		//db.shutdown();
	}
	public static List<Car> getAllCars(String querry) throws Exception{
	
		List<Car> cars = new ArrayList<>();
		
		CreateAndPopulateDB db = new CreateAndPopulateDB();
		
		Statement st = null;
        ResultSet rs = null;
        //checkOrCreateTable(db);
        st = conn.createStatement();
       
        
        rs = st.executeQuery(querry);
        cars = getCars(rs);
        st.close();
		return cars;
		}
	
	public static List<Car> getCars(ResultSet rs) throws SQLException{
		List <Car> cars = new ArrayList<>();
		System.out.println(rs);
		
		for (;rs.next();){
			Car car = new Car();
			car.setId(rs.getInt(1));
			car.setCarName(rs.getString(2));
			car.setCarRegistration(rs.getString(3));
	
			cars.add(car);
		}
	
		return cars;
	}
}
