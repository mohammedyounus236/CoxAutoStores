package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	public StoreService storeService;
	
	@GetMapping("/findall")
	public List<Store> findAll(){
		return storeService.findAll();
	}
	
	@PostMapping("/save")
	public Store newStore(@RequestBody Store store) {
		return storeService.newStore(store);
	}
	
	@PutMapping("/update")
	public Store updateStore(@RequestBody Store store) {
		storeService.updateStore(store);
		return store;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStore(@PathVariable Long id) {
		storeService.deleteStore(id);
	}
	
}
