package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Site_DAO {
private Site_DAO(){
	}
	
	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private static ResultSet rs = null;
	public static Site_DAO sdao = null;
	
	public static Site_DAO getinstance() {
		if(sdao == null) {
			sdao = new Site_DAO();
		}
		return sdao;
	}
	
	public Connection conn() {
		try { 
			Class.forName(driver); 
			conn = DriverManager.getConnection(url, id, pwd); 
			System.out.println("DB������ �Ǿ����ϴ�.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
