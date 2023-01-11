package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.example.entity.Member;
import com.example.entity.emf.UniqueEntityManagerFactory;

public class MemberService {
	
	public void save(Member member) {
		//엔티티 매니저 팩토리: 애플리케이션 당 하나만 공유
		EntityManagerFactory emf = UniqueEntityManagerFactory.emf; 
		
		//엔티티 매니저: 엔티티 매니저 팩토리를 생성한다.
		EntityManager em = emf.createEntityManager();
		
		//트랜잭션(쪼갤 수 없는 업무의 단위)
		EntityTransaction tx = em.getTransaction();
		
		//엔티티 생명주기 
		try {
			tx.begin(); //트랜잭션 시작과 동시에 커넥션을 획득
			em.persist(member); //*영속: 엔티티 매니저를 통해 엔티티를 영속성 컨텍스트에 저장. 
			tx.commit(); //실제 DB에 저장이 된다.
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //롤백 (커밋 직전으로 되돌아감)
		} finally {
			em.close(); //*준영속: 영속성 컨텍스트에서 관리하던 영속성 엔티티를 영속성 컨텍스트가 관리하지 않음.
//			em.detach(member);
//			em.clear(); //셋 중 하나를 써주면 된다! 
			
//			em.remove(member); //엔티티를 삭제 
		}
		
	}

}
