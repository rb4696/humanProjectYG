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
		System.out.println("===== ������ �����Դϴ�. =====");
		ArrayList<Site_DTO> slist = sdao.selectAll();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("=================");
			System.out.println("��ǰ��ȣ : " + sd.getNo());
			System.out.println("��ǰ�̸� : " + sd.getName());
			System.out.println("��      �� :" + sd.getLoca());
			System.out.println("������ : " + sd.getPrice());
			System.out.println("�����ڸ� : " + sd.getCnt());
			System.out.println("�������� : " + sd.getTime());
			System.out.println("�������� : " + sd.getInfo());
		}
	}

	@Test
	public void InsertTest() {
		sdao.insertOne("Tokyo", "Japan", 100, 20, "200910~200913", "�������� �� ���� �̿����� �Ϻ�");
	}

	@Test
	public void UpdateTest() {
		sdao.updatePrice(150, 3);
	}

	@Test
	public void UpdateCntTest() {
		sdao.updateCnt(3, 3);
	}

	@Test
	public void DeleteTest() {
		sdao.deleteOne(4);
	}

	@Test
	public void selecthot() {
		System.out.println("===== �α� ������ �����Դϴ�. =====");
		ArrayList<Site_DTO> slist = sdao.selectHot();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("=================");
			System.out.println("��ǰ��ȣ : " + sd.getNo());
			System.out.println("��ǰ�̸� : " + sd.getName());
			System.out.println("��      �� :" + sd.getLoca());
			System.out.println("������ : " + sd.getPrice());
			System.out.println("�����ڸ� : " + sd.getCnt());
			System.out.println("�������� : " + sd.getTime());
			System.out.println("�������� : " + sd.getInfo());
		}
	}
}
