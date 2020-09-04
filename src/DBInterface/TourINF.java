package DBInterface;

public interface TourINF {
	// 관리자
	public void insertsite();
	public void deletesite();
	public void clientlist();
	public void tourlistall();
	
	// 회원
	public void sign_in();
	public void membermod();
	public void memberdelete();
	public void siteall();
	public void selecthot();
	public void goodsbuy();
	public void goodsmod();
	
}
