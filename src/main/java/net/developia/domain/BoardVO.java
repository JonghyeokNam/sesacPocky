package net.developia.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private Date writeDate;
	private int hit;
	private int member_id;
	private int club_id;
}
