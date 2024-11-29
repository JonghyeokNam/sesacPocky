package net.developia.reply.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long id;
	private Long member_id;
	private Long board_id;
	
	private String reply;
	
	private Date replydate;
	private Date updatedate;
	
	private int likes_count;
}
