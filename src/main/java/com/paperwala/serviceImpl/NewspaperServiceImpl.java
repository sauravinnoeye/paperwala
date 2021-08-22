package com.paperwala.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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

//	@Override
//	public List<Newspaper> getAllNewspaper() {
//		try {
//			return newsDao.findAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	@Override
	public ResponseEntity<String> deleteNewspaper(Integer id) {
		try {
			newsDao.deleteById(id);
			return new ResponseEntity<>("{\"message\":\"" + "Newspaper Deleated" + "\"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{\"message\":\"" + "Something Went Wrong." + "\"}", HttpStatus.OK);
		}
	}

	@Override
	public List<NewspaperWrapper> getNewspaperByVendor(Integer id) {
		logger.info("Inside getNewspaperByVendor{}", id);
		try {
			if (id != null) {
				return newsDao.getNewspaperByVendor(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public ResponseEntity<String> updateNewspaper(Integer id, NewspaperWrapper newsPaper) {
		logger.info("Inside updateNewspaper {}", newsPaper);
		try {
			if (!Strings.isNullOrEmpty(newsPaper.getNewspaperName())
					&& !Strings.isNullOrEmpty(newsPaper.getNewspaperRate())) {
				Newspaper np = newsDao.getById(id);
				np.setNewspaperName(newsPaper.getNewspaperName());
				np.setNewspaperRate(newsPaper.getNewspaperRate());
				newsDao.save(np);
				return new ResponseEntity<>("{\"message\":\"" + "Newspaper Updated Successfully" + "\"}",
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Something Went Wrong." + "\"}", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
