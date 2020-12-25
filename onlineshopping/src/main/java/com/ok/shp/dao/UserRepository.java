package com.ok.shp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ok.shp.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Override
	public List<User> findAll();
}
