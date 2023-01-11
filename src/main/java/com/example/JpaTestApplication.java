package com.example;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.constant.MemberClass;
import com.example.entity.Member;
import com.example.entity.emf.UniqueEntityManagerFactory;
import com.example.service.MemberService;

@SpringBootApplication
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
		
		//엔티티 매니저 팩토리: hello라는 이름으로 생성 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		//애플리케이션에서 유일한 EntityManagerFactory로 설정 
		UniqueEntityManagerFactory.emf = emf;
		
		//비영속 상태의 Member 객체 생성
		Member member1 = new Member();
		member1.setName("Lamb");
		member1.setMemberclass(MemberClass.VIP);
		member1.setDate(new Date());
		
		Member member2 = new Member();
		member2.setName("sookyoung");
		member2.setMemberclass(MemberClass.ADMIN);
		member2.setDate(new Date());
		
		MemberService ms = new MemberService();
		ms.save(member1);
		ms.save(member2);

		//엔티티 매니저 팩토리 종료
		UniqueEntityManagerFactory.emf.close();
	}

}
