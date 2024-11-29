package net.developia.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

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
public class MemberTests {

   @Autowired
   private PasswordEncoder pwencoder;
   
   @Autowired
   private DataSource ds;
   
   @Ignore
   @Test
   public void testInsertUsers() {
      String sql = "insert into member(id, password, name, phone_num, email, club_id, enabled, authority) values(?,?,?,?,?,?,?,?)";
      Random random = new Random();
      
      for(int i=0; i < 50; i++) {
         Connection con = null;
         PreparedStatement pstmt = null;
         
         try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            
            int randomNum = 1000 + random.nextInt(9000);
            
            pstmt.setInt(1, i+1);
            pstmt.setString(2, pwencoder.encode("pw" + i));
            pstmt.setString(4, "010" + randomNum + "" + randomNum);
            pstmt.setString(3, "user" + i);
            pstmt.setString(5, "user" + i + "@gmail.com");
            pstmt.setInt(6, (int)(random.nextInt(5)+1));
            pstmt.setInt(7, 1);
            pstmt.setString(8, "ROLE_USER");

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
