package com.paperwala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paperwala.POJO.Newspaper;
import com.paperwala.wrapper.NewspaperWrapper;



public interface NewspaperDao  extends JpaRepository<Newspaper, Integer> {

	//List<String> (@Param("username")String username,@Param("password")String password);
	
	//List<NewspaperWrapper> getNewspaper();
}
