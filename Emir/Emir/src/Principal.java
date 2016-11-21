import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class Principal {

	static Scanner entrada = new Scanner(System.in); 
	
	public static void main(String[] args) {
	
		String _usuario="root";
		String _pwd= "";
		String _bd="rentavideos";
		String _url = "jdbc:mysql://localhost/"+_bd;
		Connection conn;;
		
		try{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
		}
		catch(SQLException ex)
		{
			System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}		
		
		
		System.out.println(" \t Menu");
		System.out.println("1. Registrar cliente");
		System.out.print("Opcion: ");
		 int opc = entrada.nextInt(); 

		 switch (opc){
		 case 1:
			 registrar();
			 break;
		 }
	}
	
	public static void registrar(){
				
		System.out.println(" \t + Registrar cliente +");
		System.out.print("Codigo cliente: ");
		int cc = entrada.nextInt();
		System.out.print("Nombre: ");
		String nombre = entrada.next();
		System.out.print("Membrecia: ");
		int membrecia = entrada.nextInt();
		

		
	}
}

