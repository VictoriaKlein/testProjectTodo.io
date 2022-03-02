package model;
import java.sql.*;

public class UserDAO {

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
	
	
	public User save (User u) {
		connect();
		try {
			PreparedStatement ps = connect().prepareStatement("insert into userlog values (?, ?)");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			String result = "failed";
		} 
		System.out.println("Successfully registered");
		return u;
		
	}
	
	public boolean get (User u) {
		connect();
		try {
			PreparedStatement ps = connect().prepareStatement("select * from userlog where username = ? and password = ?");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//String result = "failed";
		} 
		
		return false;
		
	}
public User getId (User u) {
	return u;
	
};
}
