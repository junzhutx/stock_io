package com.rainston.dailyprocessor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainston.common.model.response.BaseResponse;
import com.rainston.common.model.response.ErrorCode;

@RestController
public class DailyProcessController {
	
	@RequestMapping(value="/get-new-list", method=RequestMethod.POST)
	public BaseResponse getNewList() {
		BaseResponse response = new BaseResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		return response;
	}
}
