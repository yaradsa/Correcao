package exe01.univel.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {
   public Exercicio03(){
	  Connection con;
	try {
		con = getConexao();
		excluirTodosClientes(con);
		insereCliente(con, 1, "Joao");
		insereCliente(con, 2, "José");
		insereCliente(con, 3, "Luiz");
		mostrarTodosClientes(con);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		  
   }
   

private List<Cliente> mostrarTodosClientes(Connection con) throws SQLException {
	
	PreparedStatement ps = con.prepareStatement("INSERT * FROM cliente");
	ResultSet rs = ps.executeQuery();
	List<Cliente> lista = new ArrayList<>();
	while(rs.next()){
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
	}
	return lista;
}


private void excluirTodosClientes(Connection con) throws SQLException {
	PreparedStatement ps = con.prepareStatement("DELETE FROM cliente");
	ps.executeUpdate();
	
}


private void insereCliente(Connection con, int id, String nome) throws SQLException {
	
	PreparedStatement ps = con.prepareStatement("INSERT INTO cliente(id,nome)" + "VALUES(?,?)");
	  ps.setInt(1,id);
	  ps.setString(2, nome);
	  ps.executeUpdate();
	
}


private Connection getConexao() throws SQLException {
	  
	   Connection con = DriverManager.getConnection("jdbc:h2~/aulah2","sa","sa");
	   
	return con;
  }
 public static void main(String[] args){
	 new Exercicio03();
 }
}
