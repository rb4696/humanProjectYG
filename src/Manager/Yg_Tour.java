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
		System.out.println("=== ���ϴ� ���񽺸� �������ּ���. ===");
		System.out.println("1. ȸ������");
		System.out.println("2. ���������ϱ� ��, �ڵ�����ȣ�� ��������!");
		System.out.println("3. �����ǰ��Ϻ���");
		System.out.println("4. �α⿩���ǰ����");
		System.out.println("5. �����ǰ�����ϱ�");
		System.out.println("6. �����ǰ�����ϱ�");
		System.out.println("7. Ż���ϱ�");
		System.out.println("8. �����ϱ�");
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
		System.out.println("=== ���ϴ� ���񽺸� �������ּ���. ===");
		System.out.println("1. ȸ������Ʈ����");
		System.out.println("2. ��������Ȳ����");
		System.out.println("3. ��ǰ�� ��Ȳ����");
		System.out.println("4. �ǸſϷ��ǰ����");
		System.out.println("5. ������ �߰��ϱ�");
		System.out.println("6. ���డ�� �����ϱ�");
		System.out.println("7. ������ �����ϱ�");
		System.out.println("8. �����ϱ�");
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
		System.out.println("=== �̿��Ͻ� ���񽺸� �������ּ���. ===");
		System.out.println("1. ������ ����");
		System.out.println("2. ȸ�� ����");
		System.out.println("3. �����ϱ�");

	}
}
