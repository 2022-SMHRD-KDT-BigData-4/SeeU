package com.board.test.domain;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@RequiredArgsConstructor
@Table(name="tbl_senior")
public class Senior {
	@Id
	private int S_num;
	@NonNull
	private String S_name;
	@NonNull
	private String S_birth;
	@NonNull
	private String S_gender;
	@NonNull
	private String S_photoname;
	@NonNull
	private String S_photopath;
	@NonNull
	private String S_phone;
	@NonNull
	private String S_address;
	@NonNull
	private String S_care;
	
	private String mem_id;
	
	

	
}
