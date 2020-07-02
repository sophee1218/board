package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector
{	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/java";
	private static final String ID = "test";
	private static final String PWD = "test";
	private static Connection conn;
	
	private static void init()
	{
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		if(conn==null)
		{
			init();
			try
			{
				conn = DriverManager.getConnection(URL, ID, PWD);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void close()
	{
		if(conn!=null)
		{
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		}
		conn = null;
	}
	
}