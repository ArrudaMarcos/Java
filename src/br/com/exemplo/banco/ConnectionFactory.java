package br.com.exemplo.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
	   try {
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   return DriverManager.getConnection("jdbc:sqlserver://meusbancos.database");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}
}
	

