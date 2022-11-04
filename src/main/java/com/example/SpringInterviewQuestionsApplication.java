package com.example;

import com.example.config.PrototypeBean;
import com.example.config.SingletoneBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.example.service.PersonService;

import java.util.Arrays;

@SpringBootApplication
//@EnableConfigurationProperties
public class SpringInterviewQuestionsApplication {

	//@Autowired
	//private PersonService service;
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(SpringInterviewQuestionsApplication.class, args);
		String [] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		for(String beanName: beanNames){
			//System.out.println(beanName);
		}

		SingletoneBean firstSingleTone = ctx.getBean(SingletoneBean.class);
		PrototypeBean firstPrototype = ctx.getBean(PrototypeBean.class);

		SingletoneBean secondSingleTone = ctx.getBean(SingletoneBean.class);
		PrototypeBean secondPrototype = ctx.getBean(PrototypeBean.class);

		if(firstSingleTone.equals(secondSingleTone)){
			System.out.println("Singletone bean are equal......");
		}else{
			System.out.println("Ops S not equal");
		}

		if(firstPrototype.equals(secondPrototype)){
			System.out.println("secondPrototype bean are equal......");
		}else{
			System.out.println("Ops P not equal");
		}

		PrototypeBean p1 = firstSingleTone.getPrototypeBean();
		PrototypeBean p2 = secondSingleTone.getPrototypeBean();

		if(p1.equals(p2)){
			System.out.println("Prototype beans inside Singletone bean are equal......");
		}else{
			System.out.println("Prototype beans inside Singletone are" +
					"" +
					" not equal");
		}

		//ConfigurableApplicationContext context = SpringApplication.run(SpringInterviewQuestionsApplication.class, args);
		//System.out.println("+++++++++++++++++++++++++++++++++++++++");
		//PersonService service = new PersonService();
		//service.getPersonList();
		//ApplicationContext context = null;
		//context.getBean("0");
		//System.out.println("------------Done----------------");
	}

}
