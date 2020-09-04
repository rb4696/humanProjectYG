package JTest;

import org.junit.Before;
import org.junit.Test;

import DBInterface.TourINFImpl;

public class TourINFImpl_Test {
	TourINFImpl t = null;

	@Before
	public void t() {
		t = new TourINFImpl();
	}

	@Test
	public void insertSiteTest() {
		t.insertsite();
	}

	@Test
	public void deletesiteTest() {
		t.deletesite();
	}

	@Test
	public void clientlistTest() {
		t.clientlist();
	}
	
	@Test
	public void tourlistallTest() {
		t.tourlistall();//
	}
	
	@Test
	public void sign_inTest() {
		t.sign_in();
		//
		
	}
	
	@Test
	public void membermodTest() {
		t.membermod();
	}
	
	@Test
	public void memberdeleteTest() {
		t.memberdelete();
	}
	
	@Test
	public void siteallTest() {
		t.siteall();
	}
	
	@Test
	public void goodsbuyTest() {
		t.goodsbuy();
	}
	
	@Test
	public void goodsmodTest() {
		t.goodsmod();
	}
	
	@Test
	public void selecthotTest() {
		t.selecthot();
	}
}
