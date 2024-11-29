package net.developia.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.sql.Date;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class MemberInsertTest {

	   @Autowired
	   private DataSource ds;
	   
	   @Test
	   public void testInsertBoards() {
		  String membersql = "select club_id from member where id = ?";
	      String sql = "insert into board(bno, title, content, writedate, hit, member_id, club_id) values(?,?,?,?,?,?,?)";
	      Random random = new Random();
	      
	      for(int i=1; i < 1000; i++) {
	         Connection con = null;
	         PreparedStatement memberStmt = null;
	         PreparedStatement pstmt = null;
	         
	         try {
	            con = ds.getConnection();
	            memberStmt = con.prepareStatement(membersql);
	            int n = (int)(random.nextInt(50)+1);
	            memberStmt.setInt(1, n);
	            ResultSet rs = memberStmt.executeQuery();
	            
	            int clubId = -1;
	            if (rs.next()) {
	            	clubId = rs.getInt("club_id");
	            }
	            
	            pstmt = con.prepareStatement(sql);
	            
	            pstmt.setInt(1, i);
	            pstmt.setString(2, "new title" + i);
	            pstmt.setString(3, "new content" + i);
	            pstmt.setDate(4, Date.valueOf(LocalDate.now()));
	            pstmt.setInt(5, 0);
	            pstmt.setInt(6, n);
	            pstmt.setInt(7, clubId);

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
