package co.lsj.prj.member.serviceImpl;

import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberDelete implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		System.out.println("========회원정보 삭제==========");
		if (LogD.author.equals("ADMIN")) {
			System.out.println("삭제할 회원 아이디를 입력해주세요.");
			vo.setId(LogD.scn.nextLine());

			int n = memberService.memberDelete(vo);
			if (n != 0) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("**해당 회원이 없습니다**");
			}
		} else {
			System.out.println("삭제할 권한이 없습니다!");
 
		}
	}

}
