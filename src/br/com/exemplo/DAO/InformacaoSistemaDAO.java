package br.com.exemplo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.exemplo.banco.ConnectionFactory;
import br.com.exemplo.modelo.InformacaoSistema;

public class InformacaoSistemaDAO {
	private Connection connection;
	
	public InformacaoSistemaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(InformacaoSistema informacaoSistema) {
		String sql = "insert into maquina" +
				"(memoria_disponivel, memoria_total, usoCPU)" +
				"values(?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			//seta os valores
			stmt.setString(1, informacaoSistema.getMemoriaDisponivel());
			stmt.setString(2, informacaoSistema.getMemorialTotal());
			stmt.setString(3, informacaoSistema.getUsoCPU());
		
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	  public InformacaoSistema getInfoSistema() {
		  
          try {
        	  InformacaoSistema infoSistema = new InformacaoSistema();
        	  PreparedStatement stmt = this.connection.
                      prepareStatement("select * from maquina where id = 1");
              ResultSet rs = stmt.executeQuery();

              while (rs.next()) {            	                  
                  infoSistema.setMemoriaDisponivel(rs.getString("memoria_disponivel"));
                  infoSistema.setMemorialTotal(rs.getString("memoria_total"));
                  infoSistema.setUsoCPU(rs.getString("usoCPU"));
              }
              rs.close();
              stmt.close();
              return infoSistema;
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
	  
	  public void atualiza(InformacaoSistema infoSistema) {
		    String sql = "update maquina set memoria_disponivel=?, memoria_total=?, usoCPU=? where id = 1";
		    try {
		        PreparedStatement stmt = connection.prepareStatement(sql);
		        stmt.setString(1, infoSistema.getMemoriaDisponivel());
		        stmt.setString(2, infoSistema.getMemorialTotal());
		        stmt.setString(3, infoSistema.getUsoCPU());
		        stmt.execute();
		        stmt.close();
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
		}
		
		public void remove(int indice) {
		    try {
		        PreparedStatement stmt = connection.prepareStatement("delete " +
		                "from maquina where id=?");
		        stmt.setLong(1, indice);
		        stmt.execute();
		        stmt.close();
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
		}
}

