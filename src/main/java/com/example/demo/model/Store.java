package com.example.demo.model;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Store {



	@Id
	private Long id;
	private String type;
	private String name;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zip;
	@Embedded
	private Location location;
	//private String location;
	//private Location lat;
	//private Location lon;
	private String hours;
	@ElementCollection
	private List<String> services;
	
}
