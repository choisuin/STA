package com.spring.FreeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.FreeBoard.dao.FreeBoardDAO;
import com.spring.FreeBoard.vo.FreeBoardVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	
	@Override
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = freeBoardDAO.freeBoardList(freeBoardVO);
		
		return freeBoardList;
	}
	
	//자유게시판 글 조회하는 메서드
	/*
	@Override
	public FreeBoardVO freeBoardDetail(int fboardId) {
		return freeBoardDAO.freeBoardDetail(fboardId);
	}
	*/
	
	
	@Override
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		FreeBoardVO freeBoardDetail = freeBoardDAO.freeBoardDetail(freeBoardVO);
		
		return freeBoardDetail;
	}
	
	//조회수 증가
	@Override
	public boolean plusCnt(FreeBoardVO freeBoardVO) {
		return freeBoardDAO.plusCnt(freeBoardVO);
	}
	//게시글 등록
	@Override
	public int insertFreeBoard(FreeBoardVO freeBoardVO) {
		return freeBoardDAO.insertFreeBoard(freeBoardVO);
	}
	
	//게시글 수정
	@Override
	public int updateFreeBoard(FreeBoardVO freeBoardVO) {
		int  updatefreeboard = freeBoardDAO.updateFreeBoard(freeBoardVO);
		return updatefreeboard;
		//return freeBoardDAO.updateFreeBoard(freeBoardVO);
	}
	
	//게시글 삭제
	@Override
	public int deleteFreeBoard(FreeBoardVO freeBoardVO) {
		log.info("test");
		int deletefreeboard = freeBoardDAO.deleteFreeBoard(freeBoardVO);
		log.info("test"+ deletefreeboard);
		return deletefreeboard;
		//return freeBoardDAO.freeBoardDelete(fboardId);
	}
	
	
	

}
