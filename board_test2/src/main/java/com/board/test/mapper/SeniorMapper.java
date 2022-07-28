package com.board.test.mapper;

import java.util.List;



import org.mybatis.spring.annotation.MapperScan;

import com.board.test.domain.Board;
import com.board.test.domain.Senior;
import org.springframework.ui.ModelMap;
//@MapperScan
public interface SeniorMapper {
	
	public List<Senior> SeniorList();
	
	
	public int Seniorinsert(Senior vo);
	public int SeniorUpdate(Senior vo);
}
