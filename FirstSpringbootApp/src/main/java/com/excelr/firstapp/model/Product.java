package com.excelr.firstapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Product {
	
	private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    
}