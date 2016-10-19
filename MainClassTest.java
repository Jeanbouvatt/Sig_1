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

}
