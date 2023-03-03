package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WriteService implements Service { //�ڵ� �������̵�
	
	@Autowired
	//@Qualifier("mySQLDao") //���� �����ϰ��� �ϴ� ��ü�̸�(�տ��� �ҹ���)�� ���
	private Dao dao;
	
	public WriteService() {}
	//��ü �������� ����	
	public WriteService(Dao dao) {
		super();
		this.dao = dao;//OracleDao�ʱ�ȭ
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void insertService() {
		System.out.println("WriteSercie insertService() ȣ��");
		dao.insertBoard();
	}
}
