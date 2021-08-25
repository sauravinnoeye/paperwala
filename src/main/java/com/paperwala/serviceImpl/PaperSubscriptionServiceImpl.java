package com.paperwala.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.paperwala.POJO.PaperSubscription;
import com.paperwala.dao.NewspaperDao;
import com.paperwala.dao.PaperSubscriptionDao;
import com.paperwala.dao.UserCredentialsDao;
import com.paperwala.dao.VendorDao;
import com.paperwala.service.PaperSubscriptionService;
import com.paperwala.wrapper.PaperSubscriptionWrapper;

@Service
public class PaperSubscriptionServiceImpl implements PaperSubscriptionService {

	private Logger logger = LogManager.getLogger(PaperSubscriptionServiceImpl.class);

	@Autowired
	private VendorDao vendorDao;

	@Autowired
	private NewspaperDao newspaperDao;

	@Autowired
	private UserCredentialsDao userDao;

	@Autowired
	private PaperSubscriptionDao subsDao;

	@Override
	public ResponseEntity<String> subscribe(PaperSubscriptionWrapper subscribeWrapper) {
		logger.info("Inside subscribe service Impl {}", subscribeWrapper);
		try {
			if (validateWrapper(subscribeWrapper)) {
				List<String> list = subsDao.validSubscription(subscribeWrapper.getUser(), subscribeWrapper.getVendor(),
						subscribeWrapper.getNewspaper());
				logger.info("------{}-----{}-----{}", subscribeWrapper.getUser(), subscribeWrapper.getVendor(),
						subscribeWrapper.getNewspaper());
				if (list.isEmpty() && list.size() == 0) {
					PaperSubscription paper = new PaperSubscription();
					paper.setUser(userDao.findById(subscribeWrapper.getUser()).get());
					paper.setVendor(vendorDao.findById(subscribeWrapper.getVendor()).get());
					paper.setNewspaper(newspaperDao.findById(subscribeWrapper.getNewspaper()).get());

					Integer totalChargeByDuration = getAmountByDuration(subscribeWrapper.getDuration(),
							subscribeWrapper.getAmount(), getMonthCount(subscribeWrapper.getDuration()));

					paper.setDuration(subscribeWrapper.getDuration());
					paper.setActive(subscribeWrapper.getActive());
					paper.setTotalAmount(totalChargeByDuration.toString());

					Map<String, Date> map = getSubAndExpireDate(getMonthCount(subscribeWrapper.getDuration()));
					paper.setSubscribeDate(map.get("sDate"));
					paper.setExpireDate(map.get("eDate"));

					subsDao.save(paper);

					return new ResponseEntity<>("{\"message\":\"" + "Newspaper Subscribed" + "\"}", HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>("{\"message\":\"" + "Already Subscribed" + "\"}", HttpStatus.CREATED);
				}
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Not sufficient data." + "\"}", HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private Boolean validateWrapper(PaperSubscriptionWrapper subscribeWrapper) {
		logger.info("Inside validateWrapper service Impl {}", subscribeWrapper);
		try {
			if (!Strings.isNullOrEmpty(subscribeWrapper.getDuration())
					&& !Strings.isNullOrEmpty(subscribeWrapper.getActive()) && subscribeWrapper.getVendor() != null
					&& subscribeWrapper.getNewspaper() != null && subscribeWrapper.getUser() != null
					&& subscribeWrapper.getAmount() != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private Integer getMonthCount(String duration) {
		logger.info("Inside getMonthCount service Impl {}", duration);
		try {
			switch (duration) {
			case "Montly":
				return 1;
			case "Quaterly":
				return 4;
			case "Half Yearly":
				return 6;
			case "Yearly":
				return 12;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Integer getAmountByDuration(String duration, String amount, Integer monthCount) {
		logger.info("Inside getAmountByDuration service Impl {} {} {}", duration, amount, monthCount);
		try {
			if (amount != "0" && monthCount != 0) {
				switch (duration) {
				case "Montly":
					return getMonthlyCharges(amount);
				case "Quaterly":
					return (getMonthlyCharges(amount) * monthCount);
				case "Half Yearly":
					return (getMonthlyCharges(amount) * monthCount);
				case "Yearly":
					return (getMonthlyCharges(amount) * monthCount);
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Integer getMonthlyCharges(String amount) {
		logger.info("Inside getMonthlyCharges service Impl {}", amount);
		try {
			return (Integer) 30 * Integer.parseInt(amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<String, Date> getSubAndExpireDate(Integer months) {
		logger.info("Inside getSubAndExpireDate service Impl {}", months);
		try {

			// String subscriptionDate = dateFormat.format(today);
			// String expireDate = dateFormat.format(expire);

			Map<String, Date> map = new HashMap<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);

			Date expire = DateUtils.addMonths(new Date(), months);
			map.put("sDate", today);
			map.put("eDate", expire);
			return map;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new HashMap<>();
	}
}
