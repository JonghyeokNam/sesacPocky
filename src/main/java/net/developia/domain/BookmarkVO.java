package net.developia.domain;

import lombok.Data;

@Data
public class BookmarkVO {
	private int id;
	private boolean status;
	
	private int member_id;
	private int board_id;
}
