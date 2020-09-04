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
		System.out.println("=== 여행상품추가페이지입니다. ===");
		System.out.println("여행지 이름을 입력하세요.");
		String name = in.nextLine();
		System.out.println("여행지 국가를 입력하세요.");
		String loca = in.nextLine();
		System.out.println("가격을 입력해주세요.");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("상품의 갯수를 입력해주세요.");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("여행기간을 입력해주세요. 예) 200904~200910");
		String time = in.nextLine();
		System.out.println("여행상품정보를 입력해주세요. 단, 40자내로 입력가능");
		String info = in.nextLine();
		sdao.insertOne(name, loca, price, cnt, time, info);
	}

	@Override
	public void deletesite() {
		System.out.println("=== 여행상품제거페이지입니다. ===");
		siteall();
		System.out.println("제거를 원하는 상품의 상품번호를 입력해주시기 바랍니다.");
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
			System.out.println("===== " + (i + 1) + " 번 째 회원정보입니다. =====");
			System.out.println("순      번 : " + cd.getNo());
			System.out.println("I   D : " + cd.getId());
			System.out.println("이      름 : " + cd.getName());
			System.out.println("전화번호 : " + cd.getPhone());
			System.out.println("회원등급 : " + cd.getGrade() + "\n");
		}

	}

	@Override
	public void tourlistall() {
		System.out.println("모든 여행객의 명단입니다.");
		ArrayList<Tourlist_DTO> tolist = tdao.selectAll();
		for (int i = 0; i < tolist.size(); i++) {
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

	@Override
	public void sign_in() {
		System.out.println("=== 회원가입 페이지입니다. ===");
		System.out.println("원하시는 id를 입력해주세요. 단, 10자이하로 입력해주세요!");
		String id = in.nextLine();
		System.out.println("이름을 입력해주세요.");
		String name = in.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		String phone = in.nextLine();
		System.out.println("가입시 여행등급은 'C'등급입니다.");
		cdao.insertOne(id, name, phone, "c");
	}

	@Override
	public void membermod() {
		System.out.println("회원정보 수정페이지입니다. 단, 휴대폰번호만 변경가능합니다.");
		System.out.println("회원님의 ID를 입력해주세요.");
		String id = in.nextLine();
		System.out.println("변경할 휴대폰번호를 입력해주세요.");
		String phone = in.nextLine();
		cdao.updateOne(phone, id);
	}

	@Override
	public void memberdelete() {
		System.out.println("회원 탈퇴페이지입니다.");
		System.out.println("회원님의 ID를 입력해주세요.");
		String id = in.nextLine();
		cdao.deleteOne(id);
	}

	@Override
	public void siteall() {
		ArrayList<Site_DTO> slist = sdao.selectAll();
		for (int i = 0; i < slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("===== 여행상품정보 =====");
			System.out.println("상품번호 : " + sd.getNo());
			System.out.println("상품이름 : " + sd.getName());
			System.out.println("나      라 :" + sd.getLoca());
			System.out.println("여행경비 : " + sd.getPrice());
			System.out.println("가능자리 : " + sd.getCnt());
			System.out.println("여행일자 : " + sd.getTime());
			System.out.println("여행정보 : " + sd.getInfo());
		}

	}

	@Override
	public void goodsbuy() {
		siteall();
		System.out.println("여행상품을 구매를 원하시는 경우 'y'를 입력해주세요.");
		String k = in.nextLine();
		if (k.equals("y")) {
			System.out.println("id를 입력해주세요.");
			String id =in.nextLine();
			System.out.println("상품번호를 입력해주세요.");
			int no = in.nextInt();
			in.nextLine();
			System.out.println("이름을 입력해주세요.");
			String name = in.nextLine();
			System.out.println("나라를 입력해주세요.");
			String loca = in.nextLine();
			tdao.insertOne(id, no, name, loca);
			sdao.updateCnt(1, no);
		}
	}

	@Override
	public void goodsmod() {
		siteall();
		System.out.println("수정할 상품번호를 입력해주세요.");
		int no = in.nextInt();
		in.nextLine();
		System.out.println("수정할 가격을 입력해주세요.");
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
			System.out.println("===== 인기 여행상품정보 =====");
			System.out.println("상품번호 : " + sd.getNo());
			System.out.println("상품이름 : " + sd.getName());
			System.out.println("나      라 :" + sd.getLoca());
			System.out.println("여행경비 : " + sd.getPrice());
			System.out.println("가능자리 : " + sd.getCnt());
			System.out.println("여행일자 : " + sd.getTime());
			System.out.println("여행정보 : " + sd.getInfo());
		}
	}

	@Override
	public void selectSoldOut() {
		ArrayList<Site_DTO> slist =sdao.selectSoldOut();
		for(int i = 0; i<slist.size(); i++) {
			Site_DTO sd = new Site_DTO();
			sd = slist.get(i);
			System.out.println("===== 판매완료 여행상품정보 =====");
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
