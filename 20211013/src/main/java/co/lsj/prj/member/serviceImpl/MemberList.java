package co.lsj.prj.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.service.MemberVO;

public class MemberList implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memberService.memberSelectList();

		System.out.println("=============회원 목록============");
		if (LogD.author.equals("ADMIN")) {
			for (MemberVO member : members) {
				System.out.print(member.getId() + " : ");
				System.out.print(member.getName() + " : ");
				System.out.print(member.getPassword() + " : ");
				System.out.print(member.getTel() + " : ");
				System.out.print(member.getAddress() + " : ");
				System.out.println(member.getAuthor());

			}
			System.out.println("=============회원 목록 끝============");
		} else {
			System.out.println("권한이 없습니다!");
		}
	}
}
