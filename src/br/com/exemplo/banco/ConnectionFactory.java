package br.com.exemplo.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
	   try {
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   return DriverManager.getConnection("jdbc:sqlserver://meusbancos.database.windows.net:1433;database=MoniWeb;user=redicopa@meusbancos;password={Acesso16};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}
}
	

