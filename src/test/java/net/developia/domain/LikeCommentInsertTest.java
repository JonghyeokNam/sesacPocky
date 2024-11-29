package net.developia.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class LikeCommentInsertTest {

	   @Autowired
	   private DataSource ds;
	   
	   @Test
	   public void testInsertBoards() {
		  String boardsql = "select member_id from board where bno = ?";
	      String sql = "insert into bookmark(id, status, member_id, board_id) values(?,?,?,?)";
	      Random random = new Random();
	      
	      for(int i=1; i < 1000; i++) {
	         Connection con = null;
	         PreparedStatement boardStmt = null;
	         PreparedStatement pstmt = null;
	         
	         try {
	            con = ds.getConnection();
	            boardStmt = con.prepareStatement(boardsql);
	            
	            int n = (int)(random.nextInt(999) + 1);
	            
	            boardStmt.setInt(1, n);
	            ResultSet rs = boardStmt.executeQuery();
	            
	            int memberId = -1;
	            if (rs.next()) {
	                memberId = rs.getInt("member_id");
	            }
	            
	            pstmt = con.prepareStatement(sql);
	            
	            pstmt.setInt(1, i);
	            pstmt.setInt(2, (int)(random.nextInt(1) + 1));
	            pstmt.setInt(3, memberId);
	            pstmt.setInt(4, n);
	            
	            pstmt.executeUpdate();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            if (pstmt != null) { try {pstmt.close();} catch(Exception e) {} }
	            if (con   != null) { try {con.close();  } catch(Exception e) {} }
	         }
	      }
	   }
	   
}
