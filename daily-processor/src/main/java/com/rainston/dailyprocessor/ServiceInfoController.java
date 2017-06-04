package com.rainston.dailyprocessor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainston.common.model.ServiceInfo;

@RestController
@RequestMapping("/service-info")
public class ServiceInfoController {

		@RequestMapping(method=RequestMethod.GET, value="/version")
		public ServiceInfo getVersion() {
			ServiceInfo info = new ServiceInfo();
			info.setVersion("0.0.2");
			return info;
		}
}
