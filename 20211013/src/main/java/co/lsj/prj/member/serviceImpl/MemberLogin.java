package co.lsj.prj.member.serviceImpl;

import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberLogin {

	public void execute() {

		MemberService memberService = new MemberServiceImpl();
		boolean b = false;
		do {
			System.out.println("====== 로 그 인  ======");
			MemberVO vo = new MemberVO();
			System.out.println("아이디를 입력하세요.");
			vo.setId(LogD.scn.nextLine());
			System.out.println("비밀번호를 입력하세요.");
			vo.setPassword(LogD.scn.nextLine());

			vo = memberService.loginCheck(vo);

			if (vo != null) {
				System.out.println(vo.getName() + "님 환영합니다!");
				System.out.println("권한 : " + vo.getAuthor());
				LogD.name = vo.getName();
				LogD.author = vo.getAuthor();
				b = true;
			} else
				System.out.println("아이디 또는 비밀번호가 틀렸습니다!");

		} while (!b);
	}

}
