package com.paperwala.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.paperwala.POJO.Newspaper;
import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.VendorDao;
import com.paperwala.service.NewspaperService;
import com.paperwala.wrapper.NewspaperWrapper;

@Service
public class NewspaperServiceImpl implements NewspaperService {
	private Logger logger = LogManager.getLogger(NewspaperServiceImpl.class);

	@Autowired
	private NewspaperDao newsDao;

	@Autowired
	private VendorDao vendorDao;

	@Override
	public ResponseEntity<String> addNewsPaper(NewspaperWrapper request) {
		logger.info("----------------------Inside addNewsPaper---------------------{}", request);
		try {
			if (!Strings.isNullOrEmpty(request.getNewspaperName())
					&& !Strings.isNullOrEmpty(request.getNewspaperRate())) {
				Newspaper np = new Newspaper();
				np.setNewspaperName(request.getNewspaperName());
				np.setNewspaperRate(request.getNewspaperRate());
				np.setVendor(vendorDao.findById(request.getVendor()).get());
				logger.info("-------------------test-------------------{}", np);
				newsDao.save(np);

				return new ResponseEntity<>("{\"message\":\"" + "Newspaper Added Successfully" + "\"}",
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Not sufficient data." + "\"}", HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
