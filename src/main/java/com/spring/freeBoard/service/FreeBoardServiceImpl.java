package com.spring.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.freeBoard.dao.FreeBoardDAO;
import com.spring.freeBoard.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	
	@Override
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = null;
		freeBoardList = freeBoardDAO.freeBoardList(freeBoardVO);
		
		return freeBoardList;
	}
	/*
	public FreeBoardVO freeBoardDEtail(FreeBoardVO freeBoardVO) {
		
	}
	*/
	
	
	

}
