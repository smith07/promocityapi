package com.azeka.promocityapi.com.azeka.promocityapi.dao;

import com.azeka.promocityapi.com.azeka.promocityapi.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, String> {
}
