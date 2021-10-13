package co.lsj.prj.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardHitCount(BoardVO vo);
}
