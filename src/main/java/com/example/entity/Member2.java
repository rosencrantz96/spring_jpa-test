package com.example.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Member2")
@Getter
@Setter
@ToString
public class Member2 {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long memberId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String zipcode;
}
