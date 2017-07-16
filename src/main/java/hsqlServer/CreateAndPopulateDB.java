package hsqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import bean.Car;
import hsqlServer.createTablesHelper;
import javassist.bytecode.stackmap.TypeData.ClassName;


public class CreateAndPopulateDB {
	static Connection conn;
	
	public CreateAndPopulateDB() throws Exception {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		conn = DriverManager.getConnection("jdbc:hsqldb:C:/hsqldb-2.3.4/baza5","SA","");
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
        st = conn.createStatement();    // statements
        
        int i = st.executeUpdate(querry);    // run the query

        if (i == -1) {
           
        }

        
        //st.execute("SHUTDOWN");
        st.close();
        
    }
	
	
	public static void createTable(CreateAndPopulateDB db, List<String> table){
		Logger logger = Logger.getLogger(ClassName.class);
		
		try { 
			
			for (String querry:table){
				logger.info("Trying to create with querry: "+querry);
				db.update(querry);	
			}		
		} catch (SQLException ex2){
			logger.error(ex2);
		}
	}
	
	public static void checkOrCreateTable(CreateAndPopulateDB db) throws Exception{
		
		carsTable(db);
		calendarTable(db);
		lendTable(db);
		repairsTable(db);
	}
	
	public static void repairsTable(CreateAndPopulateDB db) throws Exception{
		List<String> table = createTablesHelper.createAndPopulateRepairsTable();
		createTable(db,table);
	}
	public static void carsTable(CreateAndPopulateDB db) throws Exception{
		List<String> table = createTablesHelper.createAndPopulateCarsTable();
        createTable(db,table);
	}
	public static void calendarTable(CreateAndPopulateDB db) throws Exception{
		List<String> table = createTablesHelper.createAndPopulateCalendarTable();
        createTable(db,table);
	}
	public static void lendTable(CreateAndPopulateDB db) throws Exception{
		List<String> table = createTablesHelper.createAndPopulateLendTable();
        createTable(db,table);
	}
	
}