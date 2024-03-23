package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

import lombok.extern.slf4j.Slf4j;

/***************************************************************************************
 * 참고 : @RestController (@Controller + @ResponesBody)
 * Controller가 REST 방식을 처리하기 위한 것임을 명시. (기존의 특정한 JSP와 같은 뷰를 만들어 
 * 내는 것이 목적이 아닌 REST 방식의 데이터 처리를 위해서 사용하는(데이터 자체를 반환) 어노테이션이다.
 * @ResponesBody: 일반적인 JSP와 같은 뷰로 전달되는 게 아니라 데이터 자체를 전달하기 위한 용도이다.
 * @PathVariable: URL 경로에 있는 값을 파라미터로 추출하려고 할 때 사용한다.
 * @RequestBody: JSON 데이터를 원하는 타입으로 바인딩 처리한다.{name:value}
 ***************************************************************************************/

@RestController
@RequestMapping("/fcomment/*")
@Slf4j
public class FcommentController {
	
	@Autowired
	private FcommentService fcommentService;

	@GetMapping(value = "all/{fboardId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FcommentVO> fcommentList(@PathVariable("fboardId") int fboardId, FcommentVO fcommentvo) {
		log.info("fcommentList 호출");
		List<FcommentVO> fcommentlist = null;
		fcommentvo.setFboardId(fboardId);
		fcommentlist = fcommentService.fcommentList(fcommentvo);
		return fcommentlist;
	}
	
	
	
/**************************************************************
* 댓글 글쓰기 구현하기
* @return String
* 참고 : @RequestBody: JSON 데이터를 원하는 타입으로 바인딩 처리한다.{name:value} 
* 		consumes 속성을 이용하면 사용자가 Request Body에 담는 타입을 제한할 수 있으며 
* 		만약 요청 데이터가 JSON이라면 요청시 헤더에 반드시 application/json이 존재해야 한다.
* 
* 		produces 속성을 추가하고 dataType을 지정하면 해당 데이터타입으로만 
* 		사용자에게 응답하겠다는 의미로 해석하면 된다.
* 현재 요청 URL : http://localhost:8080/replies/replyInsert
**************************************************************/	
	
	@PostMapping(value = "fcommentInsert", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public String fcommentInsert(@RequestBody FcommentVO fcommentvo) {
		log.info("fcommentInsert 호출 성공");
		log.info("FcommentVO : " + fcommentvo);
		int result = 0;
		
		result = fcommentService.fcommentInsert(fcommentvo);
		return(result==1) ? "SUCCESS":"FAILURE";
	}
	
	@DeleteMapping(value = "/{fcommentId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String fcommentDelete(@PathVariable("fcommentId") int fcommentId, FcommentVO fcommentvo) {
		fcommentvo.setFcommentId(fcommentId);
		int result = fcommentService.fcommentDelete(fcommentvo);
		return(result==1)?"SUCCESS":"FAILURE";
	}
	
	@PutMapping(value = "/{fcommentId}",
			consumes = "application/json",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String fcommentUpdate(@PathVariable("fcommentId") int fcommentId, @RequestBody FcommentVO fcommentvo) {
		fcommentvo.setFcommentId(fcommentId);
		int result = fcommentService.fcommentUpdate(fcommentvo);
		return(result==1)?"SUCCESS":"FAILURE";
	}
	
	@GetMapping("fcommentDetail")
	public FcommentVO fcommentDetail(Model model, FcommentVO fvo) {
		System.out.println("test call");
		FcommentVO detail = fcommentService.fcommentDetail(fvo);
		System.out.println("detail:" + detail);

		model.addAttribute("detail", detail);
		return detail;
	}
	
	
}