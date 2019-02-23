package com.infotech.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.infotech.model.Message;

public class ClientTest {

	public static void main(String[] args) 
	{
		Resource resource=new ClassPathResource("beans.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		
		Object object=beanFactory.getBean("message");
		Message message=(Message)object;
		System.out.println(message.getMessageId()+"\t"+message.getMessage());
		
		System.out.println("*******************");
		
		String[] alias=beanFactory.getAliases("message");
		for (String a:alias)
		{
			System.out.println(a);			
		}
		
		System.out.println("*******************");
		
		Message message1=beanFactory.getBean(Message.class);
		System.out.println(message.getMessageId()+"\t"+message.getMessage());
		
		System.out.println("*******************");
		
		Class<?> cls=beanFactory.getType("message");
		System.out.println(cls.getName());
	}

}
