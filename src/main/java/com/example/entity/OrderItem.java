package com.example.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Order_Item")
@Getter
@Setter
@ToString
public class OrderItem {
	@Id
	@Column(name="order_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name="order_id")
	private Long orderId;
	
	@Column(nullable = false, name="item_id")
	private Long itemId;
	
	@Column(nullable = false)
	private int orderPrice;
	
	@Column(nullable = false)
	private int count;
}
