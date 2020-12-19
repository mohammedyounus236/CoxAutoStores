package com.example.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Location {

    private String lat;
    private String lon;

}
