package co.lsj.prj.board.serviceImpl;

import co.lsj.prj.board.service.BoardService;
import co.lsj.prj.board.service.BoardVO;
import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;

public class BoardUpdate implements Command {

	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		System.out.println("========공지사항 수정==========");
		System.out.println("수정할 공지사항번호를 고르세요.");
		vo.setBId(LogD.scn.nextInt()); LogD.scn.nextLine();
		vo = boardService.boardSelect(vo);
		if (vo != null) {
			if (!LogD.name.equals(vo.getBWriter())) {
				System.out.println("본인 자료가 아닙니다!");
			} else {

				System.out.println("수정할 내용을 입력하세요.");
				vo.setBContents(LogD.scn.nextLine());

				int n = boardService.boardUpdate(vo);
				if (n != 0) {
					System.out.println("정상적으로 수정되었습니다.");
				} else {
					System.out.println("수정 실패했습니다.");
				}
			}
		} else {
			System.out.println("**게시글이 없습니다**");
		}
	}
}
