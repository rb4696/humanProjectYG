package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Tourlist_DTO;

public class Tourlist_DAO {
private Tourlist_DAO(){
	}
	
	private Connection conn = null; // oracle 접속하기 위한 연결 컨넥션
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
			System.out.println("DB연결이 되었습니다.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<Tourlist_DTO> selectAll() {
		String sql = "select * from tourlist";
		Statement st = null;
		rs = null;
		ArrayList<Tourlist_DTO> tolist = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Tourlist_DTO td = new Tourlist_DTO();
					td.setNum(rs.getInt(1));
					td.setId(rs.getString(2));
					td.setNo(rs.getInt(3));
					td.setName(rs.getString(4)); 
					td.setLoca(rs.getString(5));
					tolist.add(td);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					System.out.println("DB연결을 종료합니다.");
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return tolist;
	}
	
	public void insertOne(String id, int no, String name, String loca) {
		String sql = "insert into site values (seq_tourlist.nextval, ?, ?, ?, ?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.setInt(2, no);
				ppst.setString(3, name);
				ppst.setString(4, loca);
				ppst.execute();
				System.out.println("여행상품이 주문되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
					// System.out.println("DB연결을 종료합니다.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteOne(String id) {
		String sql = "delete from tourlist where id=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.executeUpdate();
				System.out.println("여행자 목록에서 삭제되었습니다. ");
			} catch (Exception e) {
				System.out.println("");
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
