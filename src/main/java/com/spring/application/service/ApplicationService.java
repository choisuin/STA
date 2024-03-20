package com.spring.application.service;

import java.util.List;

import com.spring.application.vo.ApplicationVO;

public interface ApplicationService {
	public int applicationCount(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationList(ApplicationVO applicationVO);
	
	public int applicationSubmit(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationView(String userId);
	
	public int applicationDelete(ApplicationVO applicationVO);
	
	public int applicatoinCheck(ApplicationVO applicatinoVO);
}
