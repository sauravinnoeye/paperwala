package com.paperwala;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.dao.VendorDao;
import com.paperwala.restImpl.NewspaperRestImpl;
import com.paperwala.restImpl.UserCredentialsRestImpl;
import com.paperwala.restImpl.VendorRestImpl;
import com.paperwala.service.VendorService;
import com.paperwala.wrapper.NewspaperWrapper;

@SpringBootTest
class ApplicationTests {

	private Logger logger = LogManager.getLogger(ApplicationTests.class);

	@Autowired
	public UserCredentialsDao user;

	@Autowired
	public UserCredentialsRestImpl service;

	@Autowired
	private VendorRestImpl vendorService;

	@Autowired
	private VendorService vendors;

	@Autowired
	private NewspaperRestImpl nservice;

	@Autowired
	VendorDao vDao;

	@Autowired
	NewspaperDao nDao;

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
//		news.setNewspaperName("Hindustan Times");
//		news.setNewspaperRate("5.75");
//		news.setVendor(1);

		// logger.info("-------------------------------------srv-------------------------------{}",nservice.addNewsPaper(news));

		// logger.info("-------------------------------------srv-------------------------------{}",nDao.getNewspaper());
		// logger.info("-------------------------------------srv-------------------------------{}",vendorService.getAllVendor());

//		logger.info("-------------------------------------srv-------------------------------{}",
//				vendorService.addVendor(vendor));

//		logger.info("-------------------------------------srv-------------------------------{}",
//				vendorService.deleteVendor(3));

//		UserCredentialsWrapper user = new UserCredentialsWrapper();
//		user.setUserName("shivani");
//		user.setUserPassword("shivani");
//		user.setUserRole("Vendor");
//		logger.info("--------------------------------srv------------------------{}", service.login(user));

		// logger.info("--------------------------------srv------------------------{}",
		// vDao.getVendor("shivani","shivani"));

		// logger.info("---------------srv-----------------------{}",nDao.getNewspaperByVendor(1));

		// logger.info("-------------------srv------------------{}",nservice.getNewspaperByVendor(1));

		NewspaperWrapper news = new NewspaperWrapper();
		news.setNewspaperName("Hindustannnnnn");
		news.setNewspaperRate("6.75");
		logger.info("--------------------------------------srv-----------------------{}",
				nservice.updateNewspaper(2, news));
	}

}
