package com.board.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity // ���� ����� Object Relation Mapping�� ��
@Data
@Table(name="tbl_board")
public class Board {
	
	@Id // PK�� �ش� ������ �ϰڴٴ� ��
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �ش� �����ͺ��̽� ��ȣ ���� ������ ���󰡰ڴ�
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
		

	
}
