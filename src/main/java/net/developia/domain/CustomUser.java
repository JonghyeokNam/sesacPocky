package net.developia.domain;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.Getter;

@Data
public class CustomUser extends User {
	
	private MemberVO member;
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(MemberVO memberVO) {
        super(
                String.valueOf(memberVO.getId()), //username
                "",               // password는 비어두거나 필요에 따라 설정 (암호화된 값 사용 권장)
                memberVO.isEanbled(), // enabled
                true,              // accountNonExpired, 기본값으로 true 설정
                true,              // credentialsNonExpired, 기본값으로 true 설정
                true,              // accountNonLocked, 기본값으로 true 설정
                AuthorityUtils.createAuthorityList("ROLE_USER") // 권한
            );
        
        this.member = memberVO;
    }
	
    public String getPhoneNum() {
    	String phone = this.member.getPhone_num();
        return phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7, 11);
    }

}
