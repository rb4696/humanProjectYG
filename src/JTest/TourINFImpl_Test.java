package JTest;

import org.junit.Before;
import org.junit.Test;

import DBInterface.TourINFImpl;

public class TourINFImpl_Test {
	TourINFImpl t =null;
	
	
	@Before 
	public void t() {
		t = new TourINFImpl();
	}
	
	@Test
	public void insertSiteTest() {
		t.insertsite();
	}
}
