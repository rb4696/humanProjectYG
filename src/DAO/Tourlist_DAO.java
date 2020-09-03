package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Tourlist_DAO {
private Tourlist_DAO(){
	}
	
	private Connection conn = null; // oracle �����ϱ� ���� ���� ���ؼ�
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private static ResultSet rs = null;
	public static Tourlist_DAO tdao = null;
	
	public static Tourlist_DAO getinstance() {
		if(tdao == null) {
			tdao = new Tourlist_DAO();
		}
		return tdao;
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
