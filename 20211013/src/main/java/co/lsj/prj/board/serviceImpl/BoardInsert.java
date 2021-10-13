package co.lsj.prj.board.serviceImpl;

import co.lsj.prj.board.service.BoardService;
import co.lsj.prj.board.service.BoardVO;
import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;

public class BoardInsert implements Command {

	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		System.out.println("========공지사항 등록==========");
//		if (LogD.author.equals("USER")) {
			vo.setBWriter(LogD.name);
			System.out.println("제목을 입력해주세요.");
			vo.setBTitle(LogD.scn.nextLine());
			System.out.println("내용을 입력해주세요.");
			vo.setBContents(LogD.scn.nextLine());
//		}else {
//			System.out.println("등록할 이름을 넣어주세요.");
//			vo.setBWriter(LogD.scn.nextLine());
//		
//			System.out.println("제목을 입력해주세요.");
//			vo.setBTitle(LogD.scn.nextLine());
//			System.out.println("내용을 입력해주세요.");
//			vo.setBContents(LogD.scn.nextLine());
//		}
		int n = boardService.boardInsert(vo);
		if (n != 0) {
			System.out.println("정상적으로 등록되었습니다.");
		} else {
			System.out.println("등록 실패했습니다.");
		}

	}

}
