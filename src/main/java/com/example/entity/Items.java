package com.example.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Item")
@Getter
@Setter
@ToString
public class Items {
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int stockQuantity;
}
