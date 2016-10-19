import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

import geoexplorer.gui.GeoMainFrame;
import geoexplorer.gui.LineString;
import geoexplorer.gui.MapPanel;
import geoexplorer.gui.Point;
import geoexplorer.gui.Polygon;

public class GraphicInterface {
	/*
	 * test the graphical interface
	 */
	public static void IGTest(){
		double centerX = 50;
		double centerY = 50;
		MapPanel panel = new MapPanel(centerX,centerY,2 * Math.max(centerX, centerY));
		Point center = new Point(centerX,centerY);
		Point p2 = new Point(80,50);
		Point p3 = new Point(50,80);
		LineString line = new LineString(Color.RED);
		line.addPoint(center);
		line.addPoint(p2);
		line.addPoint(p3);

		panel.addPrimitive(line);
		Polygon octagone = new Polygon();
		for(int i = 0; i < 8; i++){
			double sinus = Math.sin(i*Math.PI/4);
			double cosinus = Math.cos(i*Math.PI/4);
			Point p = new Point(centerX + cosinus*20, centerY + sinus*20);
			octagone.addPoint(p);
		}
		panel.addPrimitive(octagone);
		GeoMainFrame frame = new GeoMainFrame("display test",panel);
		System.out.println("success");
	}
	
	public static void main(String[] args){
		IGTest();
	}
	
	public static void addBuilding(ArrayList<Point> points, MapPanel panel){
		Polygon poly = new Polygon();
		for(Point p : points){
			poly.addPoint(p);			
		}
		panel.addPrimitive(poly);
	}
	
	public static void addRoad(ArrayList<Point> points, MapPanel panel){
		LineString line = new LineString();
		for(Point p : points){
			line.addPoint(p);			
		}
		panel.addPrimitive(line);
		
	}
	
	public static LineString somePoints(){
		Point p1 = new Point(5.7,45.1);
		Point p2 = new Point(5.75,45.1);
		Point p3 = new Point(5.8,45.1);
		Point p4 = new Point(5.7,45.15);
		Point p5 = new Point(5.75,45.15);
		Point p6 = new Point(5.8,45.15);
		Point p7 = new Point(5.7,45.2);
		Point p8 = new Point(5.75,45.2);
		Point p9 = new Point(5.8,45.2);
		LineString l1 = new LineString(Color.red);
		l1.addPoint(p1);
		l1.addPoint(p2);
		l1.addPoint(p3);
		l1.addPoint(p4);
		l1.addPoint(p5);
		l1.addPoint(p6);
		l1.addPoint(p7);
		l1.addPoint(p8);
		l1.addPoint(p9);
		return l1;
	}
}
