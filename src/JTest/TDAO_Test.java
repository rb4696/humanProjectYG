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
		System.out.println("��� ���ఴ�� ����Դϴ�.");
		ArrayList<Tourlist_DTO> tolist = tdao.selectAll();
		for(int i = 0; i<tolist.size();i++) {
			Tourlist_DTO td = new Tourlist_DTO();
			td = tolist.get(i);
			System.out.println("===== ������ ������ �����Դϴ�. =====");
			System.out.println("��ܼ��� : " + td.getNum());
			System.out.println("��ID :" + td.getId());
			System.out.println("��ǰ��ȣ : " + td.getNo() + "ȣ");
			System.out.println("�����ǰ : " + td.getName());
			System.out.println("�������� : " + td.getLoca());
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
