package com.board.test.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Data
@Table(name="tbl_board")
public class Board {
	@Id
	 // �� ��ȣ
	private int b_num;
	
	@NonNull
	private String b_title;
	
	// ����
	@NonNull
	private String b_content;
		
	// �ۼ���
	@NonNull
	private String b_writer;
		
	// �ۼ� ��¥
	@NonNull
	private String b_date;
		
	// ÷�� ����
	private String b_file;

	
}
