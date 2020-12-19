package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Store;

public interface StoreService {
	
	public List<Store> findAll();
	
	public Store newStore(Store store);
	
	public Store updateStore(Store store);
	
	public void deleteStore(Long id);
	
}
