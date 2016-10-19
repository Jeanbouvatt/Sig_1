import java.awt.Color;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import org.postgis.PGgeometry;

import database.*;
import geoexplorer.gui.CoordinateConverter;
import geoexplorer.gui.GeoMainFrame;
import geoexplorer.gui.LineString;
import geoexplorer.gui.MapPanel;
import geoexplorer.gui.Point;

public class MainClass {
	
	public static String WayRequest = "SELECT ST_ASTEXT(ST_Transform(ways.linestring, 4326)) "
			+ "FROM ways "
			+ "WHERE ST_Intersects(ST_MakeEnvelope(5.7, 45.1, 5.8, 45.2, 4326), ST_Transform(ways.linestring, 4326)) ";

	public static String pubRequest = "SELECT ST_ASTEXT(ST_Transform(ways.linestring, 4326)) "
			+ "FROM ways "
			+ "WHERE ST_Intersects(ST_MakeEnvelope(5.7, 45.1, 5.8, 45.2, 4326), ST_Transform(ways.linestring, 4326)) "
			+ "AND ways.tags->'amenity' = 'bar';";
	
	public static void main(String[] args){
		//décommentez la question que vous voulez tester.
		//Les temps peuvent être très long, (coté serveur?)
		//question10();
		//simpleRequest("Dom__ne _niversit%");
		//question11();
		// MapPanel.autoajust ne marche pas.. donc il faut scroller avec la souris pour bien voir la carte
		//question12();
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
	
	public static void question12(){
		double centerX = 5.75;
		double centerY = 45.15;
		double mapWidth = 0.1;
		MapPanel panel = new MapPanel(centerX,centerY,mapWidth);
		List<LineString> ways = getWays();
		ways.add(GraphicInterface.somePoints());
		ways.stream().forEach(ls -> panel.addPrimitive(ls));
		System.out.println(ways.size());
		GeoMainFrame frame = new GeoMainFrame("display test",panel);
	}
	
	private static List<LineString> getWays(){
		List<LineString> ways = new ArrayList();
		try{
			PreparedStatement stmt;
			//TODO: mettre la bonne requete.
			stmt = Utils.getConnection().prepareStatement(WayRequest);
			ResultSet res = stmt.executeQuery();
			while(res.next()){
				ways.add(new LineString(res.getString(1), Color.BLACK));
			stmt = Utils.getConnection().prepareStatement(pubRequest);
			res = stmt.executeQuery();
			while(res.next()){
				ways.add(new LineString(res.getString(1), Color.RED));
			}
			return ways;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
