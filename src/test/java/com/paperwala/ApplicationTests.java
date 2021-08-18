package com.paperwala;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.restImpl.VendorRestImpl;
import com.paperwala.service.NewspaperService;
import com.paperwala.service.UserCredentialsService;

@SpringBootTest
class ApplicationTests {

	private Logger logger = LogManager.getLogger(ApplicationTests.class);

	
	@Autowired
	public UserCredentialsDao user;
	
	@Autowired
	public UserCredentialsService service;
	
	@Autowired
	private VendorRestImpl vendorService;
	
	@Autowired
	private NewspaperService nservice;
	
	@Autowired
	private NewspaperDao nDao;
	
	@Test
	void contextLoads() {
		
		//System.out.println("-----------------srv----------------"+user.getUser("saurav", "pass"));
		
		//logger.info("-------------------------srv----------------{}",service.login("saurav", "pass"));
		
//		VendorWrapper vendor = new VendorWrapper();
//		vendor.setVendorName("Ritik");
//		//vendor.setType("Wholeseler");
//		vendor.setAgency("ritikKhawar");
//		vendor.setContact("123456789");
//		vendor.setUniqueId("VND-123456897231");
//		vendor.setVendorAddress("Radisson Blue, Indore");
//		vendor.setUserName("roll");
//		vendor.setPassword("roll");
		//logger.info("-------------------------------------srv-------------------------------{}",vendorService.addVendor(vendor));
		
//		NewspaperWrapper news = new NewspaperWrapper();
//		news.setNewspaperName("Hindustan");
//		news.setNewspaperRate("5.75");
//		news.setVendor(1);
//		
//		logger.info("-------------------------------------srv-------------------------------{}",nservice.addNewsPaper(news));
		
		
		
		logger.info("-------------------------------------srv-------------------------------{}",nDao.getNewspaper());
		
	}

}
