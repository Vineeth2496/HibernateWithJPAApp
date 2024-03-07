package com.HibernateJPA.model.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.HibernateJPA.model.Employee;

public class Test {

	public static void main(String[] args) {
		try {
			//1. Create EntityManagerFactory
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("sampleDB");
			System.out.println(factory.getClass().getName());
			//2. Create EntityManager
			EntityManager em=factory.createEntityManager();
			
			//3. Start Transaction
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			
			//4. Perform Operation
			Employee emp=new Employee();
			emp.setEmpId(101);
			emp.setEmpName("KATHERINE LANGFORD");
			emp.setEmpSal(50000.00);
			
			em.persist(emp); // INSERT INTO EMPTAB...
			//5. Commit Transaction
			tx.commit();
			//6. Close EntityManager
			em.close();
			//7. Close EntityManagerFactory
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
