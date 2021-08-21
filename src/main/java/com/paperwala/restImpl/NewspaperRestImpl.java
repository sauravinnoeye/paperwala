package com.paperwala.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paperwala.POJO.Newspaper;
import com.paperwala.service.NewspaperService;
import com.paperwala.wrapper.NewspaperWrapper;

@RestController
@RequestMapping(path = "/newspaper")
@CrossOrigin(origins = "*")
public class NewspaperRestImpl {

	@Autowired
	private NewspaperService service;

	@PostMapping("/addNewspaper")
	public ResponseEntity<String> addNewspaper(@RequestBody(required = true) NewspaperWrapper wrapper) {
		try {
			return service.addNewsPaper(wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getNewspaperByVendor/{id}")
	public List<Newspaper> getNewspaperByVendor(@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.getNewspaperByVendor(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/deleteNewspaper/{id}")
	public ResponseEntity<String> deleteNewspaper(@PathVariable(required = true, name = "id") Integer id) {
		try {
			return service.deleteNewspaper(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
