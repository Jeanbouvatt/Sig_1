import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import geoexplorer.gui.*;

public class MainClassTest {

	@Test
	public void testQuestion10() {
		try{
			MainClass.question10();
		}catch (Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testSimpleRequest() {
		try{
			MainClass.simpleRequest("Dom__ne _niversit%\"");
		}catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	public static void IGTest(){
		double centerX = 50;
		double centerY = 50;
		MapPanel panel = new MapPanel(centerX,centerY,2 * Math.max(centerX, centerY));
		Point center = new Point(centerX,centerY);
		Point p2 = new Point(80,50);
		LineString line = new LineString(Color.RED);
		line.addPoint(center);
		line.addPoint(p2);
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
}
