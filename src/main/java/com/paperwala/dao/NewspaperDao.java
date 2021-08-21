package com.paperwala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.paperwala.POJO.Newspaper;

public interface NewspaperDao extends JpaRepository<Newspaper, Integer> {

	// List<String> (@Param("username")String username,@Param("password")String
	// password);

	// List<NewspaperWrapper> getNewspaper();

	List<Newspaper> getNewspaperByVendor(@Param("id") Integer id);
}
