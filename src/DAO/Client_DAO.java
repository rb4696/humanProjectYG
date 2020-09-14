package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Client_DTO;

public class Client_DAO {
	private Client_DAO() {

	}

	private Connection conn = null; // oracle 접속하기 위한 연결 컨넥션
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private static ResultSet rs = null;
	public static Client_DAO cdao = null;

	public static Client_DAO getinstance() {
		if (cdao == null) {
			cdao = new Client_DAO();
		}
		return cdao;
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

	public ArrayList<Client_DTO> selectAll() {
		String sql = "select * from client";
		Statement st = null;
		rs = null;
		ArrayList<Client_DTO> tlist = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Client_DTO cd = new Client_DTO();
					cd.setNo(rs.getInt(1));
					cd.setId(rs.getString(2));
					cd.setName(rs.getString(3));
					cd.setPhone(rs.getString(4));
					cd.setGrade(rs.getString(5));
					tlist.add(cd);
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
		return tlist;
	}

	public void insertOne(String id, String name, String phone, String grade) {
		String sql = "insert into client values (seq_client.nextval, ?, ?, ?, default)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.setString(2, name);
				ppst.setString(3, phone);
				ppst.execute();
				System.out.println("가입이 완료되었습니다.");
			} catch (Exception e) {
				System.out.println("가입이 불가합니다.");
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void updateOne(String phone, String id) {
		String sql = "update client set phone = ? where id = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, phone);
				ppst.setString(2, id);
				ppst.execute();
				System.out.println("정보수정이 완료되었습니다.");
			} catch (Exception e) {
				System.out.println("정보수정을 다시 해주시기 바랍니다.");
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

	public void deleteOne(String id) {
		String sql = "delete from client where id=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.executeUpdate();
				System.out.println("탈퇴가 완료되었습니다.");
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
