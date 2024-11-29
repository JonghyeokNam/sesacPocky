package net.developia.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private Date writeDate;	
	private Long hit;
	private Long member_id;
	private Long club_id;
	
}
