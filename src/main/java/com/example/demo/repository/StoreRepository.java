package com.example.demo.repository;

import com.example.demo.model.Store;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface StoreRepository extends CrudRepository<Store, Long>{
	
	List<Store> findAll();
	
}
