package co.lsj.prj.member.serviceImpl;

import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberInsert implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String id;
		if (LogD.author.equals("ADMIN")) {
			System.out.println("========회원정보 등록==========");
			System.out.println("등록할 회원 ID를 입력하세요.");
			id = LogD.scn.nextLine();
			vo.setId(id);

			vo = memberService.memberSelect(vo);
			if (vo == null) {
				vo = new MemberVO();
				vo.setId(id);
				System.out.println("등록할 회원 이름을 입력하세요.");
				vo.setName(LogD.scn.nextLine());
				System.out.println("등록할 비밀번호를 입력하세요.");
				vo.setPassword(LogD.scn.nextLine());
				System.out.println("핸드폰번호를 입력하세요.");
				vo.setTel(LogD.scn.nextLine());
				System.out.println("주소를 입력하세요.");
				vo.setAddress(LogD.scn.nextLine());

				int n = memberService.memberInsert(vo);

				if (n != 0) {
					System.out.println("정상적으로 등록되었습니다.");
				} else {
					System.out.println("등록 실패했습니다.");
				}
			} else
				System.out.println("이미 등록된 ID입니다.");
		} else {
			System.out.println("권한이 없습니다!");
		}

	}

}
