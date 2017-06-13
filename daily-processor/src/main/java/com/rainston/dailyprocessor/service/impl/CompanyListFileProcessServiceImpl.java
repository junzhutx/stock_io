package com.rainston.dailyprocessor.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

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
			for (String exchange : patterns) {
				File dir = new File(CSV_FILE_DIR + exchange);
				File[] files = dir.listFiles();
				for (File file : files) {
					String fileName = file.getName();
					System.out.println("Got a file " + fileName + " " + file.lastModified());
					Processedcsv pcsv = processedcsvRepo.findByFilename(fileName);
					String quoteDate = FileProcessorUtils.getQuoteDate(fileName);
					if (pcsv == null) {
						Reader is = new FileReader(file);
						Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(is);
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
						pcsv.setFileName(fileName);
						pcsv.setFileSize(file.length());
						pcsv.setFileCreateTime(file.lastModified());
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
