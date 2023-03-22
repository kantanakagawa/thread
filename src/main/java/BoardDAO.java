import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sample_board.Board;
import sample_board.BoardDTO;

public class BoardDAO{
	private final String URL = "jdbc:mysql://localhost/thread?";
	private final String USER = "root";
	private final String PASS = "password";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	
	public void connect() {
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoardDTO select() {
		ResultSet rs = null;
		BoardDTO bdto = new BoardDTO();
		String sql = "select * from board";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board bd = new Board();
				bd.setId(rs.getInt("id"));
				bd.setName(rs.getString("name"));
				bd.setContent(rs.getString("content"));
				bdto.add(bd);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return bdto;
	}
	
	public BoardDTO oneselect(Board bd) {
		ResultSet rs = null;
		BoardDTO bdto = new BoardDTO();
		String sql = "select * from board where id = ?";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bd.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bd.setId(rs.getInt("id"));
				bd.setName(rs.getString("name"));
				bd.setContent(rs.getString("content"));
				bdto.add(bd);
			}
			
		} catch(Exception e) {
			  e.printStackTrace();
		  } finally {
			  try {
				  if(pstmt != null) pstmt.close();
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
			  disconnect();
			  return bdto;
	}
	
	public void disconnect() {
		try {
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	  public void insert(Board board) {
		  String sql = "insert into board(name,content) values(?,?)";
		  executeSql(sql,board);
	  }
	  public void delete(Board board) {
		  String sql = "delete from board where id =?";
		  executeSql(sql,board);
	  }
	  
	  public void update(Board board) {
		  String sql = "update board set name = ? , content = ? where id = ?";
		  executeSql(sql,board);
	  }
	  
	  public void executeSql(String sql, Board bd) {
		  try {
			  connect();
			  pstmt = con.prepareStatement(sql);
			  if(sql.startsWith("insert")) {
				  pstmt.setString(1, bd.getName());
				  pstmt.setString(2, bd.getContent());  
			  } else if(sql.startsWith("delete")) {
				  pstmt.setInt(1, bd.getId());
			  } else if(sql.startsWith("update")) {
				  pstmt.setString(1, bd.getName());
				  pstmt.setString(2, bd.getContent());
				  pstmt.setInt(3, bd.getId());
			  }
			  pstmt.executeUpdate();
	  } catch(Exception e) {
		  e.printStackTrace();
	  } finally {
		  try {
			  if(pstmt != null) pstmt.close();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
		  disconnect();
	  }
}