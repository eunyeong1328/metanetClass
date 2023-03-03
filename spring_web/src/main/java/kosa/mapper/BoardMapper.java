package kosa.mapper;

import java.util.List;

import kosa.model.Board;
import kosa.model.Search;

public interface BoardMapper {
	int insertBoard(Board board);
	List<Board> listBoard(Search search);
	Board detailBoard(int seq);

}
