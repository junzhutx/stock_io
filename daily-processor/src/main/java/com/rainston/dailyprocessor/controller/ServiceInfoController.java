package com.rainston.dailyprocessor.controller;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

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
			ArrayList<String> cp = new ArrayList<String>();
			
			ClassLoader cl = ClassLoader.getSystemClassLoader();
	        URL[] urls = ((URLClassLoader)cl).getURLs();
	        for(URL url: urls){
	        	cp.add(url.getFile());
	        }
	        
	        info.setClasspath(cp);
			return info;
		}
}
