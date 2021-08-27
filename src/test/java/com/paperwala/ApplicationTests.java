package com.paperwala;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.PaperSubscriptionDao;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.dao.VendorDao;
import com.paperwala.restImpl.NewspaperRestImpl;
import com.paperwala.restImpl.PaperSubscriptionRestImpl;
import com.paperwala.restImpl.UserCredentialsRestImpl;
import com.paperwala.restImpl.VendorRestImpl;
import com.paperwala.service.VendorService;

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
	private PaperSubscriptionRestImpl subsService;

	@Autowired
	VendorDao vDao;

	@Autowired
	NewspaperDao nDao;
	
	@Autowired
	PaperSubscriptionDao paperDao;
	
	@Test
	void contextLoads() throws ParseException {

		// System.out.println("-----------------srv----------------"+user.getUser("saurav",
		// "pass"));

//		UserCredentialsWrapper user = new UserCredentialsWrapper();
//		user.setUserName("shivani");
//		user.setUserPassword("shivani");
//
//		logger.info("-------------------------srv----------------{}", service.login(user));

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

//		NewspaperWrapper news = new NewspaperWrapper();
//		news.setNewspaperName("Hindustan");
//		news.setNewspaperRate("300");
//		logger.info("--------------------------------------srv-----------------------{}",
//				nservice.updateNewspaper(2, news));

//		SimpleDateFormat formatter = new SimpleDateFormat(
//			      "dd/MM/yyyy");
//		Date date = formatter.parse(formatter.format(new Date()));
//	    logger.info("----------------- srv ---------------{}-------",LocalDate.now());

		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		
//		//LocalDate date = LocalDate.now();
//		
//		Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
//		String subscriptionDate = dateFormat.format(today);
//		
//		
//		Date expire = DateUtils.addMonths(new Date(), 1);
//		String expireDate = dateFormat.format(expire);

		
		
		
		//Date date1=dateFormat.parse(todayNew);  

		// LocalDate newDatee = (LocalDate)newDate;
		//logger.info("----------------- srv ---------------{}--------{}------", today,expire);
		
		
//		PaperSubscriptionWrapper paper = new PaperSubscriptionWrapper();
//		paper.setUser(1);
//		paper.setVendor(1);
//		paper.setNewspaper(2);
//		paper.setActive("Yes");
//		paper.setAmount("6");
//		paper.setDuration("Quaterly");
//		
//		logger.info("--------------------srv-----------------------{}",subsService.subscribe(paper));
		
		//logger.info("--------------------srv-----------------------{}",paperDao.getDetailForVendorByVendorId(1));
//		
//		
//		logger.info("--------------------srv----2-------------------{}",paperDao.validSubscription(3, 1, 2));
		logger.info("--------------------srv-----------------------{}",paperDao.getDetailForUserByUserId(3));
		
		logger.info("--------------------srv-----------------------{}",paperDao.getDetailForUserByUserId(2));
		

	}

}
