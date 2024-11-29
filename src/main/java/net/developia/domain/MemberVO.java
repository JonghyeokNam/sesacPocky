package net.developia.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int id;
	private String name;
	private String password;
	private String phone_num;
	private String email;
	private Long club_id;
	private String club_name;
	
	private boolean eanbled;
	private String authority;
}
