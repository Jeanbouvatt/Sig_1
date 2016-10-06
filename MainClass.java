import databasePutain.*;

import java.sql.*;

import geoexplorer.gui.*;

import org.postgis.*;

import org.postgresql.*;

public class MainClass {
	public static void main(String[] args){
		System.out.println("hello bitches! It works");
		question10();
	}
	public static void question10(){
		try {
			Connection connection;
			PreparedStatement stmt;
			stmt = Utils.getConnection().prepareStatement("SELECT COUNT(Id) FROM Users;");
			ResultSet res = stmt.executeQuery();
			res.next();
			System.out.println("requête finie! : nombe d'user :" + res.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void question11(){
		try {
			Connection connection;
			PreparedStatement stmt;
			stmt = Utils.getConnection().prepareStatement(" SELECT St_astext(ST_Centroid(linestring)) FROM ways WHERE tags->'amenity' = 'townhall' AND tags->'name' LIKE '%Grenoble%';");
			ResultSet res = stmt.executeQuery();
			System.out.println("requête finie!");
			while (res.next()) {
			    System.out.println("colonne 1 = " + res.getInt(1) + "; colonne 2 = " + ((PGgeometry) res.getObject(2)).getGeometry());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
