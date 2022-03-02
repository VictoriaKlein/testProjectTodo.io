package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoDAO {

	Connection connection = null;
	public Connection connect () {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/TODOlist";
			String username = "postgres";
			String password = "22vi11ka47";
			connection = DriverManager.getConnection(url, username,password);
			//return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
		}
	
	public void insert (Todo t) {
	try {
		connect();
		System.out.println("connected");
		PreparedStatement ps = connect ().prepareStatement("insert into todos values (?)");
		ps.setString(1, t.getTodoDesc());
        ps.executeUpdate();
        System.out.println(t.getTodoDesc());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	};
	public void delete (Todo t) {
		try {
			connect();
			System.out.println("connected");
			PreparedStatement ps = connect ().prepareStatement("insert into todos values (?)");
			ps.setString(1, t.getTodoDesc());
	        ps.executeUpdate();
	        System.out.println(t.getTodoDesc());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		};	
//	};
//	public delete () {
//		
//	};
//	public update (
//			) {};

}
