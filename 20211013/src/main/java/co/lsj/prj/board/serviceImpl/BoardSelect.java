package co.lsj.prj.board.serviceImpl;

import co.lsj.prj.board.service.BoardService;
import co.lsj.prj.board.service.BoardVO;
import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;

public class BoardSelect implements Command {

	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		System.out.println("조회할 공지사항 번호를 입력하세요");
		vo.setBId(LogD.scn.nextInt());LogD.scn.nextLine();

		vo = boardService.boardSelect(vo);
		if (vo != null) {			
			System.out.println("======" + vo.getBId() + "번 공지사항======");
			System.out.print(vo.getBId() + " : ");
			System.out.print(vo.getBWriter() + " : ");
			System.out.print(vo.getBWriteDate() + " : ");
			System.out.print(vo.getBTitle() + " : ");
			System.out.print(vo.getBContents() + " : ");
			System.out.println(vo.getBHit());
			System.out.println("=============== 끝 ===============");

			boardService.boardHitCount(vo);
		} else {
			System.out.println("**게시글이 없습니다**");
		}
	}

}
