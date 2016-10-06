import databasePutain.*;

import java.sql.*;
import java.util.Scanner;

import geoexplorer.gui.*;

import org.postgis.*;

import org.postgresql.*;

public class MainClass {
	public static void main(String[] args){
		System.out.println("hello bitches! It works");
		question10();
		question11();
	}
	public static void question10(){
		try {
			Connection connection;
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
			Connection connection;
			PreparedStatement stmt;
			//TODO: mettre la bonne requete.
			stmt = Utils.getConnection().prepareStatement("SELECT tags->'name',St_X(geom),St_Y(geom) FROM nodes WHERE tags->'name' LIKE '" + name + "';");
			ResultSet res = stmt.executeQuery();
			System.out.println("WHAT");
			while (res.next()) {
			    //System.out.println("colonne 1 = " + res.getInt(1) + "; colonne 2 = " + ((PGgeometry) res.getObject(2)).getGeometry());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void question11(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		while(!reader.nextLine().equals("exit")){
			System.out.println("lol");
		}
		System.out.println("exiting");
		
	}
}
