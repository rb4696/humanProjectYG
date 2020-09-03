package JTest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.Client_DAO;
import DTO.Client_DTO;

public class CDAO_Test {
	Client_DAO cdao = null;

	@Before
	public void loading() {
		cdao = Client_DAO.getinstance();
	}

	@Test
	public void SelectallTest() {
		ArrayList<Client_DTO> clist = cdao.selectAll();
		for(int i = 0; i < clist.size(); i++) {
			Client_DTO cd = new Client_DTO();
			cd = clist.get(i);
			System.out.println("===== " + (i+1) +" �� ° ȸ�������Դϴ�. =====");
			System.out.println("��      �� : " + cd.getNo());
			System.out.println("I   D : " + cd.getId());
			System.out.println("��      �� : " +  cd.getName());
			System.out.println("��ȭ��ȣ : " + cd.getPhone());
			System.out.println("ȸ����� : " + cd.getGrade() +"\n");
		}
	}
	
	@Test
	public void insertTest() {
		cdao.insertOne("test", "park", "010-2323-4453", "D");
	}
	
	@Test
	public void UpdateTest() {
		cdao.updateOne("010-0000-0000","yk" );
	}
	
	@Test
	public void DeleteTest() {
		cdao.deleteOne("yk");
	}
}
