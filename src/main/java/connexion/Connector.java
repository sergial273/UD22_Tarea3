package connexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.Asignado;
import models.Cientifico;
import models.Proyecto;

public class Connector {
	
	private String connection = "jdbc:mysql://localhost:33060";
	private String user = "root";
	private String pass = "password";
	private Connection conexion;
	
	private void connect() {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conexion = DriverManager.getConnection(connection,user,pass);
        	System.out.println("ServerConnected");
        	
        }catch(SQLException | ClassNotFoundException ex) {
        	System.out.println("no se ha podido establecer la conexion con la base de datos");
        	System.out.println(ex);
        }
	}
	
	private void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion con el servidor");
		}catch(SQLException ex) {
			System.out.println(ex);

		}
	}
	
	public Cientifico leer(String id){
		Cientifico cientif = new Cientifico();
		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			String consultaMostrarArticulos = "SELECT * FROM Cientificos WHERE id="+id;
			
	        java.sql.ResultSet resultado = statement.executeQuery(consultaMostrarArticulos);
	        
	        while (resultado.next()) {
	        	int id2 = resultado.getInt("id");
	            String nombre = resultado.getString("nombre");
	            cientif.setId(id2);
	            cientif.setName(nombre);
	        }
	        
	        closeConnection();
	        return cientif;
            
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		closeConnection();
		return null;
	}
	
	public Proyecto leerVideo(String id){
		Proyecto proy = new Proyecto();
		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			String consultaMostrarArticulos = "SELECT * FROM Proyecto WHERE id="+id;
			
	        java.sql.ResultSet resultado = statement.executeQuery(consultaMostrarArticulos);
	        
	        while (resultado.next()) {
	        	int id2 = resultado.getInt("id");
	            String nombre = resultado.getString("nombre");
	            int horas = resultado.getInt("horas");
	            proy.setId(id2);
	            proy.setNombre(nombre);
	            proy.setHoras(horas);
	        }
	        closeConnection();
	        return proy;
            
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		closeConnection();
		return null;
	}
	
	public Asignado leerAsignado(String id_cien, String id_proy){
		Asignado asig = new Asignado();
		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			String consultaMostrarArticulos = "SELECT * FROM Asignado_a WHERE id_cien="+id_cien+" and id_proy="+id_proy;
			
	        java.sql.ResultSet resultado = statement.executeQuery(consultaMostrarArticulos);
	        
	        while (resultado.next()) {
	        	int id1 = resultado.getInt("id_cien");
	            int id2 = resultado.getInt("id_proy");
	            asig.setId_cien(id1);
	            asig.setId_proy(id2);
	        }
	        closeConnection();
	        return asig;
            
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		closeConnection();
		return null;
	}
	
	public boolean escribir(String nombreTextField, String apellidoTextField) {
		
		try {
			Cientifico cientifico = new Cientifico();
			cientifico.setName(nombreTextField);
	        cientifico.setDni(Integer.parseInt(apellidoTextField));

			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			// Define la sentencia SQL para la inserción
            String sql = "INSERT INTO Cientificos (dni, nombre) VALUES (?, ?)";

            // Crea un PreparedStatement para ejecutar la sentencia SQL
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);


            // Establece los valores de los parámetros en el PreparedStatement
            preparedStatement.setInt(1, cientifico.getDni());
            preparedStatement.setString(2, cientifico.getName());

            int rowsAffected = preparedStatement.executeUpdate();
            
	        closeConnection();
	         
            if (rowsAffected > 0) {
            	return true;
            } else {
                return false;
            }
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean escribirProyecto(String tituloTextField, String directorTextField) {
		
		try {
			Proyecto proy = new Proyecto();
			proy.setNombre(tituloTextField);
			proy.setHoras(Integer.parseInt(directorTextField));

			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			// Define la sentencia SQL para la inserción
            String sql = "INSERT INTO Proyecto (nombre, horas) VALUES (?, ?)";

            // Crea un PreparedStatement para ejecutar la sentencia SQL
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);


            // Establece los valores de los parámetros en el PreparedStatement
            preparedStatement.setString(1, proy.getNombre());
            preparedStatement.setInt(2, proy.getHoras());

            int rowsAffected = preparedStatement.executeUpdate();
            
	        closeConnection();
	         
            if (rowsAffected > 0) {
            	return true;
            } else {
                return false;
            }
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
public boolean escribirAsignado(String cien, String proy) {
		
		try {
			Asignado asig = new Asignado();
			asig.setId_cien(Integer.parseInt(cien));
			asig.setId_proy(Integer.parseInt(proy));

			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			// Define la sentencia SQL para la inserción
            String sql = "INSERT INTO Asignado_a (id_cien, id_proy) VALUES (?, ?)";

            // Crea un PreparedStatement para ejecutar la sentencia SQL
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);


            // Establece los valores de los parámetros en el PreparedStatement
            preparedStatement.setInt(1, asig.getId_cien());
            preparedStatement.setInt(2, asig.getId_proy());

            int rowsAffected = preparedStatement.executeUpdate();
            
	        closeConnection();
	         
            if (rowsAffected > 0) {
            	return true;
            } else {
                return false;
            }
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean quitar(String id){

		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
            String sql = "DELETE FROM Cientificos WHERE id = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id));

            int rowsAffected = preparedStatement.executeUpdate();
            
            closeConnection();
            
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
	        
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean quitarVideo(String id){

		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
            String sql = "DELETE FROM Proyecto WHERE id = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id));

            int rowsAffected = preparedStatement.executeUpdate();
            
            closeConnection();
            
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
	        
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean quitarAsignado(String id_cien, String id_proy){

		try {
			connect();
			
			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("USE ClientesDB3");
			
			String sql = "DELETE FROM Asignado_a WHERE id_cien = ? AND id_proy = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(id_cien));
            preparedStatement.setInt(2, Integer.parseInt(id_proy));

            int rowsAffected = preparedStatement.executeUpdate();
            
            closeConnection();
            
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
	        
            
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
}