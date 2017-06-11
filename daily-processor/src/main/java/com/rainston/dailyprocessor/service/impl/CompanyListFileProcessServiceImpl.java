package com.rainston.dailyprocessor.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.rainston.common.model.LastProcessed;
import com.rainston.common.repository.LastProcessedRepository;
import com.rainston.dailyprocessor.service.CompanyListProcessService;

public class CompanyListFileProcessServiceImpl implements CompanyListProcessService {
	
	@Autowired
	LastProcessedRepository lastProcessedRepo;
	
	public boolean processNewFiles() {
		List<LastProcessed> lastProcessed = lastProcessedRepo.findAll();
		HashMap<String, LastProcessed> lastProcessedMap = new HashMap<String, LastProcessed>();
		
		// convert array to map
		for (LastProcessed item : lastProcessed) {
			lastProcessedMap.put(item.getExanchange(), item);
		}
		
		try {
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			
			for (String exchange : patterns) {
				Resource[] resources = resolver.getResources("/" + exchange + "/**");
				for (Resource res : resources) {
					System.out.println("Got a file " + res.getFilename());
				}
			}
		} catch (IOException ex) {
			// log here
			return false;
		}
		
		return true;
	}

}
