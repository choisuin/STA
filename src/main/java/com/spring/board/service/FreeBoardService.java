package com.spring.board.service;

import java.util.List;

import com.spring.board.vo.FreeBoardVO;

public interface FreeBoardService {
	// 자유게시판 글 목록
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);

	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);

	// 조회수 증가 메서드
	public boolean plusCnt(FreeBoardVO freeBoardVO);

	// 게시글 등록하는 메서드
	public int insertFreeBoard(FreeBoardVO freeBoardVO);

	// 게시글 수정
	public int updateFreeBoard(FreeBoardVO freeBoardVO);

	// 게시글 삭제
	public int deleteFreeBoard(FreeBoardVO freeBoardVO);

	// 게시글 갯수 카운트
	public int freeBoardListCnt(FreeBoardVO freeBoardVO);
}
