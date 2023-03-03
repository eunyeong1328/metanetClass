package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정파일 역할
public class Factory {
	
	@Bean
	public Dao oracleDao(){
		return new OracleDao();
	}
	
	@Bean
	public Service writeService2() {
		return new WriteService(); //객체 안 넣고 defalt
	}

}
