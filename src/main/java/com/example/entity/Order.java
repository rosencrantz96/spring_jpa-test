package com.example.entity;

import java.util.Date;

import javax.persistence.*;

import com.example.constant.OrderStatus;

import lombok.*;

@Entity
@Table(name="Orders")
@Getter
@Setter
@ToString
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Long memberId;
	
	private Date orderDate;
	
	private OrderStatus staus;
}
