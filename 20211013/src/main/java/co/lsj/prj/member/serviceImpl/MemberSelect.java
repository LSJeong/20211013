package co.lsj.prj.member.serviceImpl;

import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberSelect implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		System.out.println("========회원정보 검색==========");
		System.out.println("검색할 회원 ID를 입력하세요.");
		vo.setId(LogD.scn.nextLine());
		vo = memberService.memberSelect(vo);
		if (vo != null) {
			if (!LogD.author.equals("ADMIN") && !LogD.name.equals(vo.getName())) {
				System.out.println("USER 계정은 본인정보만 조회할수있습니");
			} else {
				System.out.print(vo.getId() + " : ");
				System.out.print(vo.getName() + " : ");
				System.out.print(vo.getPassword() + " : ");
				System.out.print(vo.getTel() + " : ");
				System.out.print(vo.getAddress() + " : ");
				System.out.println(vo.getAuthor());
			}
		} else {
			System.out.println("해당 회원이 없습니다.");
		}
	}

}
