package com.rainston.companylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-info")
public class ServiceInfoController {

		@RequestMapping(method=RequestMethod.GET, value="/version")
		public String getVersion() {
			return "{ \"version\": \"0.0.1\" }";
		}
}
