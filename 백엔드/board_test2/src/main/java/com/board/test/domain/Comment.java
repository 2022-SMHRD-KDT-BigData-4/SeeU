package com.board.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Data
@Table(name="tbl_comment")
public class Comment {
	@Id
	private int c_num;
	
	
	@NonNull
	private int b_num;
	

	@NonNull
	private String c_content;
		

	@NonNull
	private String c_date;
		

	@NonNull
	private String mem_id;
		
	
	public String toCom() {
	      return "Comment [c_content=" + c_content+ ", b_num=" + b_num + "]";
	   }
	
	
	
}
	