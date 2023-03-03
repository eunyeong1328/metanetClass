package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WriteService implements Service { //자동 오버라이딩
	
	@Autowired
	//@Qualifier("mySQLDao") //내가 선택하고자 하는 객체이름(앞에만 소문자)을 명시
	private Dao dao;
	
	public WriteService() {}
	//객체 의존관계 생성	
	public WriteService(Dao dao) {
		super();
		this.dao = dao;//OracleDao초기화
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void insertService() {
		System.out.println("WriteSercie insertService() 호출");
		dao.insertBoard();
	}
}
