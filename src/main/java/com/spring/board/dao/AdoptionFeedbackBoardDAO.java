package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.board.vo.AdoptionFeedbackBoardVO;

@Mapper
public interface AdoptionFeedbackBoardDAO {
	
	//입양후기게시판 글 목록
	public List<AdoptionFeedbackBoardVO> adoptionFeedbackBoardList(AdoptionFeedbackBoardVO afbvo);
	
	public AdoptionFeedbackBoardVO adoptionFeedbackBoardDetail(AdoptionFeedbackBoardVO afbvo);
	
	//조회수 증가 메서드
	public boolean plusCnt(AdoptionFeedbackBoardVO afbvo);
	
	//게시글 등록하는 메서드
	public int insertAdoptionFeedbackBoard(AdoptionFeedbackBoardVO afbvo);
	
	//게시글 수정
	public int updateAdoptionFeedbackBoard(AdoptionFeedbackBoardVO afbvo);
	
	//게시글 삭제
	public int deleteAdoptionFeedbackBoard(AdoptionFeedbackBoardVO afbvo);
	
	
	

}