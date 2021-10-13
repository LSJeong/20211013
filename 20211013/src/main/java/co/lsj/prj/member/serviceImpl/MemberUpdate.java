package co.lsj.prj.member.serviceImpl;

import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		System.out.println("========회원정보 수정==========");
		System.out.println("수정할 아이디를 입력하세요.");
		vo.setId(LogD.scn.nextLine());
		vo = memberService.memberSelect(vo);  //id 입력 -> select 이름받아옴
		
		if (!LogD.name.equals(vo.getName())) { //받아온이름이랑 로그인한 이름 같지않으면? 
			System.out.println("본인 자료가 아닙니다!");
		} else {	//같으면 자기꺼 수정?
//			System.out.println("수정할 아이디를 입력하세요.");
//			vo.setId(LogD.scn.nextLine());
			System.out.println("수정할 회원이름을 입력하세요.");
			vo.setName(LogD.scn.nextLine());
			System.out.println("수정할 비밀번호를 입력하세요.");
			vo.setPassword(LogD.scn.nextLine());
			System.out.println("수정할 전화번호를 입력하세요.");
			vo.setTel(LogD.scn.nextLine());
			System.out.println("수정할 주소를 입력하세요.");
			vo.setAddress(LogD.scn.nextLine());
			System.out.println("수정할 권한을 입력하세요.[ADMIN/USER]");
			vo.setAuthor(LogD.scn.nextLine());
			
			int n = memberService.memberUpdate(vo);
			
			if (n != 0) {
				System.out.println("정상적으로 수정되었습니다.");

				LogD.name = vo.getName(); //바뀐이름 전역변수에 재 저장
				LogD.author = vo.getAuthor();
			} else {
				System.out.println("수정 실패했습니다.");
			}
		}
	
	}

}
