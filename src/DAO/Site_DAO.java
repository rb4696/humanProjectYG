package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Site_DTO;

public class Site_DAO {
	private Site_DAO() {
	}

	private Connection conn = null; // oracle 접속하기 위한 연결 컨넥션
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private static ResultSet rs = null;
	public static Site_DAO sdao = null;

	public static Site_DAO getinstance() {
		if (sdao == null) {
			sdao = new Site_DAO();
		}
		return sdao;
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

	public ArrayList<Site_DTO> selectAll() {
		String sql = "select * from site where cnt >= 1";
		Statement st = null;// 정적쿼리문
		rs = null;
		ArrayList<Site_DTO> tempList = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) { // 여러개의 튜플이 존재할수 있기 때문에 while문을 썼음.
					Site_DTO sd = new Site_DTO();
					sd.setNo(rs.getInt(1));
					sd.setName(rs.getString(2));
					sd.setLoca(rs.getString(3));
					sd.setPrice(rs.getInt(4));
					sd.setCnt(rs.getInt(5));
					sd.setTime(rs.getString(6));
					sd.setInfo(rs.getString(7));
					tempList.add(sd);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tempList;
	}
	
	public ArrayList<Site_DTO> selectHot() {
		String sql = "select * from site where cnt <= 5";
		Statement st = null;// 정적쿼리문
		rs = null;
		ArrayList<Site_DTO> tempList = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) { // 여러개의 튜플이 존재할수 있기 때문에 while문을 썼음.
					Site_DTO sd = new Site_DTO();
					sd.setNo(rs.getInt(1));
					sd.setName(rs.getString(2));
					sd.setLoca(rs.getString(3));
					sd.setPrice(rs.getInt(4));
					sd.setCnt(rs.getInt(5));
					sd.setTime(rs.getString(6));
					sd.setInfo(rs.getString(7));
					tempList.add(sd);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tempList;
	}
	
	public ArrayList<Site_DTO> selectSod() {
		String sql = "select * from site where cnt = 0";
		Statement st = null;// 정적쿼리문
		rs = null;
		ArrayList<Site_DTO> tempList = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) { // 여러개의 튜플이 존재할수 있기 때문에 while문을 썼음.
					Site_DTO sd = new Site_DTO();
					sd.setNo(rs.getInt(1));
					sd.setName(rs.getString(2));
					sd.setLoca(rs.getString(3));
					sd.setPrice(rs.getInt(4));
					sd.setCnt(rs.getInt(5));
					sd.setTime(rs.getString(6));
					sd.setInfo(rs.getString(7));
					tempList.add(sd);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tempList;
	}

	public void insertOne(String name, String loca, int price, int cnt, String time, String info) {
		String sql = "insert into site values (seq_site.nextval, ?, ?, ?, ?, ?,?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, name);
				ppst.setString(2, loca);
				ppst.setInt(3, price);
				ppst.setInt(4, cnt);
				ppst.setString(5, time);
				ppst.setString(6, info);
				ppst.execute();
				System.out.println("여행지가 추가되었습니다.");
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
	
	public void updatePrice(int price, int no) {
		String sql = "update site set price = ? where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, price);
				ppst.setInt(2, no);
				ppst.execute();
				System.out.println("여행비 수정이 완료되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception
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
	
	public void updateCnt(int cnt, int no) {
		String sql = "update site set cnt = cnt - ? where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setInt(2, no);
				ppst.execute();
				System.out.println("잔여 여행 상품수가 수정되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception
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
	
	public void deleteOne(int no) {
		String sql = "delete from site where no=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.executeUpdate();
				System.out.println("여행지 삭제가 완료되었씁니다.");
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
