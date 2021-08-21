package com.paperwala;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.dao.VendorDao;
import com.paperwala.restImpl.VendorRestImpl;
import com.paperwala.service.UserCredentialsService;
import com.paperwala.service.VendorService;
import com.paperwala.wrapper.UserCredentialsWrapper;
import com.paperwala.wrapper.VendorWrapper;

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
	private VendorService vendors;

//	@Autowired
//	private NewspaperService nservice;

	@Autowired
	VendorDao vDao;

	@Autowired
	private NewspaperDao nDao;

	@Test
	void contextLoads() {

		// System.out.println("-----------------srv----------------"+user.getUser("saurav",
		// "pass"));

		// logger.info("-------------------------srv----------------{}",service.login("saurav",
		// "pass"));

//		VendorWrapper vendor = new VendorWrapper();
//		vendor.setVendorName("Gaurav");
//		vendor.setType("Wholeseler");
//		vendor.setAgency("SauravNews");
//		vendor.setContact("123456789");
//		vendor.setUniqueId("VND-123456897231");
//		vendor.setVendorAddress("Radisson Blue, Indore");
//		vendor.setUserName("roll");
//		vendor.setPassword("roll");
		// logger.info("-------------------------------------srv-------------------------------{}",vendorService.addVendor(vendor));

//		NewspaperWrapper news = new NewspaperWrapper();
//		news.setNewspaperName("Hindustan");
//		news.setNewspaperRate("5.75");
//		news.setVendor(1);
//		
//		logger.info("-------------------------------------srv-------------------------------{}",nservice.addNewsPaper(news));

		// logger.info("-------------------------------------srv-------------------------------{}",nDao.getNewspaper());
		// logger.info("-------------------------------------srv-------------------------------{}",vendorService.getAllVendor());

//		logger.info("-------------------------------------srv-------------------------------{}",
//				vendorService.addVendor(vendor));

//		logger.info("-------------------------------------srv-------------------------------{}",
//				vendorService.deleteVendor(3));

		UserCredentialsWrapper user = new UserCredentialsWrapper();
		user.setUserName("saurav");
		user.setUserPassword("saurav");
		logger.info("--------------------------------srv------------------------{}", service.login(user));
	}

}
