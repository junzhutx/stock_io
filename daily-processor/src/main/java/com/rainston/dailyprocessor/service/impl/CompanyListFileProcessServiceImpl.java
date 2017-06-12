package com.rainston.dailyprocessor.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.rainston.common.model.Company;
import com.rainston.common.model.Processedcsv;
import com.rainston.common.model.Stock;
import com.rainston.common.repository.CompanyRepository;
import com.rainston.common.repository.ProcessedcsvRepository;
import com.rainston.common.repository.StockRepository;
import com.rainston.common.utils.FileProcessorUtils;
import com.rainston.dailyprocessor.service.CompanyListProcessService;

public class CompanyListFileProcessServiceImpl implements CompanyListProcessService {
	
	@Autowired
	ProcessedcsvRepository processedcsvRepo;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	public boolean processNewFiles() {
		try {
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			
			for (String exchange : patterns) {
				Resource[] resources = resolver.getResources("/" + exchange + "/**");
				for (Resource res : resources) {
					System.out.println("Got a file " + res.getFilename() + " " + res.lastModified());
					Processedcsv pcsv = processedcsvRepo.findByFilename(res.getFilename());
					String quoteDate = FileProcessorUtils.getQuoteDate(res.getFilename());
					if (pcsv == null) {
						InputStream is = res.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(br);
						for (CSVRecord record : records) {
							String symbol = record.get(CSV_HEADER_SYMBOL);
							Company aCompany = companyRepository.findBySymbol(symbol);
							if (aCompany == null) {
								aCompany = new Company();
								aCompany.setSymbol(symbol);
								aCompany.setExchange(exchange);
								aCompany.setName(record.get(CSV_HEADER_NAME));
								aCompany.setIpoYear(record.get(CSV_HEADER_IPOYEAR));
								aCompany.setSector(record.get(CSV_HEADER_SECTOR));
								aCompany.setIndustry(record.get(CSV_HEADER_INDUSTRY));
								companyRepository.save(aCompany);
							}
							Stock stock = new Stock();
							stock.setSymbol(symbol);
							stock.setQouteDate(quoteDate);
							// last sale could be n/a
							String lastSale = record.get(CSV_HEADER_LASTSALE);
							if (lastSale.equals("n/a")) {
								stock.setLastSale(0.0);
							} else {
								stock.setLastSale(Double.parseDouble(lastSale));
							}
							stock.setMarketCap(record.get(CSV_HEADER_MARKETCAP));
							stockRepository.save(stock);
						}
						pcsv = new Processedcsv();
						pcsv.setFileName(res.getFilename());
						pcsv.setFileSize(res.contentLength());
						pcsv.setFileCreateTime(res.lastModified());
						processedcsvRepo.save(pcsv);
					}
				}
			}
		} catch (IOException ex) {
			// log here
			return false;
		}
		
		return true;
	}

}
