package DBInterface;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.Client_DAO;
import DAO.Site_DAO;
import DAO.Tourlist_DAO;
import DTO.Client_DTO;
import DTO.Site_DTO;
import DTO.Tourlist_DTO;

public class TourINFImpl implements TourINF {
	private Client_DAO cdao = Client_DAO.getinstance();
	private Site_DAO sdao = Site_DAO.getinstance();
	private Tourlist_DAO tdao = Tourlist_DAO.getinstance();
	private Scanner in = new Scanner(System.in);

	@Override
	public void insertsite() {
		System.out.println("=== �����ǰ�߰��������Դϴ�. ===");
		System.out.println("������ �̸��� �Է��ϼ���.");
		String name = in.nextLine();
		System.out.println("������ ������ �Է��ϼ���.");
		String loca = in.nextLine();
		System.out.println("������ �Է����ּ���.");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("��ǰ�� ������ �Է����ּ���.");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("����Ⱓ�� �Է����ּ���. ��) 200904~200910");
		String time = in.nextLine();
		System.out.println("�����ǰ������ �Է����ּ���. ��, 40�ڳ��� �Է°���");
		String info = in.nextLine();
		sdao.insertOne(name, loca, price, cnt, time, info);
	}

	@Override
	public void deletesite() {
		System.out.println("=== �����ǰ�����������Դϴ�. ===");
		siteall();
		System.out.println("���Ÿ� ���ϴ� ��ǰ�� ��ǰ��ȣ�� �Է����ֽñ� �ٶ��ϴ�.");
		int no = in.nextInt();
		in.nextLine();
		sdao.deleteOne(no);
	}

	@Override
	public void clientlist() {
		ArrayList<Client_DTO> clist = cdao.selectAll();
		for (int i = 0; i < clist.size(); i++) {
			Client_DTO cd = new Client_DTO();
			cd = clist.get(i);
			System.out.println("===== " + (i + 1) + " �� ° ȸ�������Դϴ�. =====");
			System.out.println("��      �� : " + cd.getNo());
			System.out.println("I   D : " + cd.getId());
			System.out.println("��      �� : " + cd.getName());
			System.out.println("��ȭ��ȣ : " + cd.getPhone());
			System.out.println("ȸ����� : " + cd.getGrade() + "\n");
		}

	}

	@Override
	public void tourlistall() {
		System.out.println("��� ���ఴ�� ����Դϴ�.");
		ArrayList<Tourlist_DTO> tolist = tdao.selectAll();
		for (int i = 0; i < tolist.size(); i++) {
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

	@Override
	public void sign_in() {
		System.out.println("=== ȸ������ �������Դϴ�. ===");
		System.out.println("���Ͻô� id�� �Է����ּ���. ��, 10�����Ϸ� �Է����ּ���!");
		String id = in.nextLine();
		System.out.println("�̸��� �Է����ּ���.");
		String name = in.nextLine();
		System.out.println("��ȭ��ȣ�� �Է����ּ���.");
		String phone = in.nextLine();
		System.out.println("���Խ� �������� 'C'����Դϴ�.");
		cdao.insertOne(id, name, phone, "c");
	}

	@Override
	public void membermod() {
		System.out.println("ȸ������ �����������Դϴ�. ��, �޴�����ȣ�� ���氡���մϴ�.");
		System.out.println("ȸ������ ID�� �Է����ּ���.");
		String id = in.nextLine();
		System.out.println("������ �޴�����ȣ�� �Է����ּ���.");
		String phone = in.nextLine();
		cdao.updateOne(phone, id);
	}

	@Override
	public void memberdelete() {
		System.out.println("ȸ�� Ż���������Դϴ�.");
		System.out.println("ȸ������ ID�� �Է����ּ���.");
		String id = in.nextLine();
		cdao.deleteOne(id);
	}

	@Override
	public void siteall() {
		ArrayList<Site_DTO> slist = sdao.selectAll();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("===== �����ǰ���� =====");
			System.out.println("��ǰ��ȣ : " + sd.getNo());
			System.out.println("��ǰ�̸� : " + sd.getName());
			System.out.println("��      �� :" + sd.getLoca());
			System.out.println("������ : " + sd.getPrice());
			System.out.println("�����ڸ� : " + sd.getCnt());
			System.out.println("�������� : " + sd.getTime());
			System.out.println("�������� : " + sd.getInfo());
		}

	}

	@Override
	public void goodsbuy() {
		siteall();
		System.out.println("�����ǰ�� ���Ÿ� ���Ͻô� ��� 'y'�� �Է����ּ���.");
		String k = in.nextLine();
		if (k.equals("y")) {
			System.out.println("id�� �Է����ּ���.");
			String id =in.nextLine();
			System.out.println("��ǰ��ȣ�� �Է����ּ���.");
			int no = in.nextInt();
			in.nextLine();
			System.out.println("�̸��� �Է����ּ���.");
			String name = in.nextLine();
			System.out.println("���� �Է����ּ���.");
			String loca = in.nextLine();
			tdao.insertOne(id, no, name, loca);
			sdao.updateCnt(1, no);
		}
	}

	@Override
	public void goodsmod() {
		siteall();
		System.out.println("������ ��ǰ��ȣ�� �Է����ּ���.");
		int no = in.nextInt();
		in.nextLine();
		System.out.println("������ ������ �Է����ּ���.");
		int price = in.nextInt();
		in.nextLine();
		sdao.updatePrice(price, no);
	}

	@Override
	public void selecthot() {
		ArrayList<Site_DTO> slist =sdao.selectHot();
		for(int i = 0; i<slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("===== �α� �����ǰ���� =====");
			System.out.println("��ǰ��ȣ : " + sd.getNo());
			System.out.println("��ǰ�̸� : " + sd.getName());
			System.out.println("��      �� :" + sd.getLoca());
			System.out.println("������ : " + sd.getPrice());
			System.out.println("�����ڸ� : " + sd.getCnt());
			System.out.println("�������� : " + sd.getTime());
			System.out.println("�������� : " + sd.getInfo());
		}
	}

	@Override
	public void selectSoldOut() {
		ArrayList<Site_DTO> slist =sdao.selectSoldOut();
		for(int i = 0; i<slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("===== �ǸſϷ� �����ǰ���� =====");
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
