package com.rainston.dailyprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainston.common.model.response.BaseResponse;
import com.rainston.common.model.response.ErrorCode;
import com.rainston.dailyprocessor.service.CompanyListProcessService;

@RestController
public class DailyProcessController {
	
	@Autowired
	CompanyListProcessService fileProcesser;
	
	@RequestMapping(value="/get-new-list", method=RequestMethod.POST)
	public BaseResponse getNewList() {
		fileProcesser.processNewFiles();
		BaseResponse response = new BaseResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		return response;
	}
}
