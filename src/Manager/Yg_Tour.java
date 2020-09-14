package Manager;

import java.util.Scanner;

import DBInterface.TourINFImpl;

public class Yg_Tour {

	private Scanner in = new Scanner(System.in);
	private TourINFImpl timp = new TourINFImpl();

	public Yg_Tour() {
		int selnum = -1;
		while (selnum < 3) {
			menu();
			selnum = in.nextInt();
			in.nextLine();
			switch (selnum) {
			case 1:
				manage();
				break;
			case 2:
				member();
				break;
			case 3:
				selnum = 3;
				break;
			default:
			}
		}

	}

	private void member() {
		int selnum = -1;
		while (selnum < 8) {
			membermenu();
			selnum = in.nextInt();
			in.nextLine();
			switch (selnum) {
			case 1:
				sign_in();
				break;
			case 2:
				membermod();
				break;
			case 3:
				siteall();
				break;
			case 4:
				hotsite();
				break;
			case 5:
				goodsbuy();
				break;
			case 6:
				buymod();
				break;
			case 7:
				memberdelete();
				break;
			case 8:
				selnum = 8;
				break;
			default:
			}
		}
	}

	private void goodsmod() {
		timp.goodsmod();

	}

	private void goodsbuy() {
		timp.goodsbuy();
	}

	private void siteall() {
		timp.siteall();
	}

	private void memberdelete() {
		timp.memberdelete();
	}

	private void membermod() {
		timp.membermod();
	}

	private void sign_in() {
		timp.sign_in();
	}

	private void membermenu() {
		System.out.println("=== 원하는 서비스를 선택해주세요. ===");
		System.out.println("1. 회원가입");
		System.out.println("2. 정보수정하기 단, 핸드폰번호만 수정가능!");
		System.out.println("3. 여행상품목록보기");
		System.out.println("4. 인기여행상품보기");
		System.out.println("5. 여행상품구매하기");
		System.out.println("6. 여행상품변경하기");
		System.out.println("7. 탈퇴하기");
		System.out.println("8. 종료하기");
	}

	private void manage() {
		int selnum = -1;
		while (selnum < 8) {
			managemenu();
			selnum = in.nextInt();
			in.nextLine();
			switch (selnum) {
			case 1:
				clientlist();
				break;
			case 2:
				siteall();
				break;
			case 3:
				tourlist();
				break;
			case 4:
				soldoutsite();
				break;
			case 5:
				insertsite();
				break;
			case 6:
				goodsmod();
				break;
			case 7:
				deletesite();
				break;
			case 8:
				selnum = 8;
				break;
			default:
			}
		}

	}

	private void managemenu() {
		System.out.println("=== 원하는 서비스를 선택해주세요. ===");
		System.out.println("1. 회원리스트보기");
		System.out.println("2. 여행지현황보기");
		System.out.println("3. 상품별 현황보기");
		System.out.println("4. 판매완료상품보기");
		System.out.println("5. 여행지 추가하기");
		System.out.println("6. 여행가격 수정하기");
		System.out.println("7. 여행지 삭제하기");
		System.out.println("8. 종료하기");
	}

	private void buymod() {
		timp.buymod();
	}

	private void soldoutsite() {
		timp.selectSoldOut();
	}

	private void hotsite() {
		timp.selecthot();
	}

	private void tourlist() {
		timp.tourlistall();
	}

	private void insertsite() {
		timp.insertsite();
	}

	private void deletesite() {
		timp.deletesite();
	}

	private void clientlist() {
		timp.clientlist();
	}

	private void menu() {
		System.out.println("=== 이용하실 서비스를 선택해주세요. ===");
		System.out.println("1. 관리자 서비스");
		System.out.println("2. 회원 서비스");
		System.out.println("3. 종료하기");

	}
}
