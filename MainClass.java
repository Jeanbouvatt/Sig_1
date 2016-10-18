import java.sql.*;
import java.util.Scanner;


import database.*;

public class MainClass {
	public static void main(String[] args){
		//question10();
		//simpleRequest("Dom__ne _niversit%");
		//question11();
	}
	public static void question10(){
		try {
			PreparedStatement stmt;
			stmt = Utils.getConnection().prepareStatement("SELECT COUNT(Id) FROM Users;");
			ResultSet res = stmt.executeQuery();
			res.next();
			System.out.println("Nombe d'utilisateur :" + res.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void simpleRequest(String name){
		try {
			PreparedStatement stmt;
			//TODO: mettre la bonne requete.
			String statement = "SELECT tags->'name',St_X(geom),St_Y(geom) FROM nodes WHERE tags->'name' LIKE '" + name + "';";
			stmt = Utils.getConnection().prepareStatement(statement);
			ResultSet res = stmt.executeQuery();
			//res.next();
			//System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3));
			while (res.next()) {
			    System.out.println(res.getString(1) + "; X = " + res.getFloat(2) + "; Y = " + res.getFloat(3));//((PGgeometry) res.getObject(2)).getGeometry());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void question11(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String line = "";
		do{
			line = reader.nextLine();
			if(!line.equals("exit")){
				simpleRequest(line);
			}
		}while(!line.equals("exit"));
		
		System.out.println("exiting");		
		reader.close();
	}
}
