package com.supenghao.service;

import java.beans.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
	
	/*public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		StudentDAO dao = (StudentDAO) ctx.getBean("studentDAO", StudentDAO.class);
	
	}*/
	/*@Autowired
	private StudentDAO sDao;
	
	@Autowired
	private Student s;
	
	public void saveStudent(){
		sDao.saveStudent(s);
	}*/

}
