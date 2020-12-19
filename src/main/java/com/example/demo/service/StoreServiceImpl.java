package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository repository;
	
	public List<Store> findAll() {
		return repository.findAll();
	}

	public Store newStore(Store store) {
		return repository.save(store);
	}

	public Store updateStore(Store store) {
		/*
		 * if(store.equals(null)) { return; }
		 */
		Optional<Store> s = repository.findById(store.getId());
		if(s.isPresent()) {
			Store db = s.get();
			db.setType(store.getType());
			db.setName(store.getName());
			db.setAddress(store.getAddress());
			db.setAddress2(store.getAddress2());
			db.setCity(store.getCity());
			db.setState(store.getState());
			db.setZip(store.getZip());
			db.setLocation(store.getLocation());
			db.setHours(store.getHours());
			db.setServices(store.getServices());
			repository.save(db);
		}
		return null;
	}

	public void deleteStore(Long id) {
		//Optional<Store> s = repository.findById(id);
		//s.ifPresent(entity -> repository.delete(entity));
		repository.deleteById(id);
		System.out.println("Store id= " + id + " deleted successfully");
	}

}
