package JTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.Site_DAO;
import DTO.Site_DTO;

public class SDAO_Test {

	Site_DAO sdao = null;

	@Before
	public void loading() {
		sdao = Site_DAO.getinstance();
	}

	@Test
	public void SelectAllTest() {
		System.out.println("===== 여행지 정보입니다. =====");
		ArrayList<Site_DTO> slist = sdao.selectAll();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("=================");
			System.out.println("상품번호 : " + sd.getNo());
			System.out.println("상품이름 : " + sd.getName());
			System.out.println("나      라 :" + sd.getLoca());
			System.out.println("여행경비 : " + sd.getPrice());
			System.out.println("가능자리 : " + sd.getCnt());
			System.out.println("여행일자 : " + sd.getTime());
			System.out.println("여행정보 : " + sd.getInfo());
		}
	}

	@Test
	public void InsertTest() {
		sdao.insertOne("incheon", "korea", 10, 0, "200910~200913", "세계적인 도시 인천");
	}

	@Test
	public void UpdatepriceTest() {
		sdao.updatePrice(20, 5);
	}

	@Test
	public void UpdateCntTest() {
		sdao.updateCnt(10, 3);
	}

	@Test
	public void DeleteTest() {
		sdao.deleteOne(7);
	}
	
	@Test
	public void selectSoldOut() {
		System.out.println("===== 판매완료 여행지 정보입니다. =====");
		ArrayList<Site_DTO> slist = sdao.selectSoldOut();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("=================");
			System.out.println("상품번호 : " + sd.getNo());
			System.out.println("상품이름 : " + sd.getName());
			System.out.println("나      라 :" + sd.getLoca());
			System.out.println("여행경비 : " + sd.getPrice());
			System.out.println("가능자리 : 없음" );
			System.out.println("여행일자 : " + sd.getTime());
			System.out.println("여행정보 : " + sd.getInfo());
		}
	}

	@Test
	public void selecthot() {
		System.out.println("===== 인기 여행지 정보입니다. =====");
		ArrayList<Site_DTO> slist = sdao.selectHot();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("=================");
			System.out.println("상품번호 : " + sd.getNo());
			System.out.println("상품이름 : " + sd.getName());
			System.out.println("나      라 :" + sd.getLoca());
			System.out.println("여행경비 : " + sd.getPrice());
			System.out.println("가능자리 : " + sd.getCnt());
			System.out.println("여행일자 : " + sd.getTime());
			System.out.println("여행정보 : " + sd.getInfo());
		}
	}
}
