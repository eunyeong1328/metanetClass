package kosa.di;

import org.springframework.stereotype.Repository;

@Repository
public class OracleDao implements Dao{

	public void insertBoard() {
		System.out.println("OracleDao insertBoard() ȣ��");
	}

}
