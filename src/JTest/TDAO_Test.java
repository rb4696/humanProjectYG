package JTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.Tourlist_DAO;
import DTO.Tourlist_DTO;

public class TDAO_Test {
	Tourlist_DAO tdao=null;
	
	@Before
	public void loading() {
		tdao = Tourlist_DAO.getinstance();
	}
	
	@Test
	public void SeletAllTest() {
		System.out.println("모든 여행객의 명단입니다.");
		ArrayList<Tourlist_DTO> tolist = tdao.selectAll();
		for(int i = 0; i<tolist.size();i++) {
			Tourlist_DTO td = new Tourlist_DTO();
			td = tolist.get(i);
			System.out.println("===== 소중한 고객님의 정보입니다. =====");
			System.out.println("명단순번 : " + td.getNum());
			System.out.println("고객ID :" + td.getId());
			System.out.println("상품번호 : " + td.getNo() + "호");
			System.out.println("여행상품 : " + td.getName());
			System.out.println("여행지역 : " + td.getLoca());
		}
	}
	
	@Test
	public void InsertTest() {
		tdao.insertOne("aaa", 2, "newyork", "usa");
	}
	
	@Test
	public void UpdateTest() {
		tdao.Update(1, "jeju_do", "korea", "aaa");
	}
	
	@Test
	public void DeleteTest() {
		tdao.deleteOne("aaa");
	}
}
