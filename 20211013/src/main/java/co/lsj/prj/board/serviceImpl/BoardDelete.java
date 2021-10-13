package co.lsj.prj.board.serviceImpl;

import co.lsj.prj.board.service.BoardService;
import co.lsj.prj.board.service.BoardVO;
import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;

public class BoardDelete implements Command {
	
	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		System.out.println("========공지사항 삭제==========");
		if (LogD.author.equals("ADMIN")) {
			System.out.println("삭제할 공지사항 번호를 선택해주세요.");
			vo.setBId(LogD.scn.nextInt());

			int n = boardService.boardDelete(vo);
			if (n != 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("**해당번호의 공지사항이 없습니다**");
			}
		} else {
			System.out.println("삭제할 권한이 없습니다.");
		}

	}

}
