package by.htp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.htp.utils.PropertiesManager.getUrl;
import static by.htp.utils.PropertiesManager.getLogin;
import static by.htp.utils.PropertiesManager.getPass;;

public class BDConection {

	private static PreparedStatement pre;
	private static Connection con;

	public static PreparedStatement getPS(String request) throws SQLException {
		con = DriverManager.getConnection(getUrl(), getLogin(), getPass());
		pre = con.prepareStatement(request);
		return pre;
	}

}
