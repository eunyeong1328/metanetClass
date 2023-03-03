package kosa.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Resource resource 
			= new ClassPathResource("applicationContext.xml");
		//객체 생성과 의존관계 설정 spring 컨테이너
//		BeanFactory factory 
//			= new GenericXmlApplicationContext(resource);
		
		ApplicationContext factory 
		= new AnnotationConfigApplicationContext(Factory.class);//설정파일로 해서 가져옴
		
		Service service = (Service) factory.getBean("writeService2");
		service.insertService();
	}
}
