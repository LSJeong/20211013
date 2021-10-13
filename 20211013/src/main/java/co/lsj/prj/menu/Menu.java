package co.lsj.prj.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

import co.lsj.prj.board.serviceImpl.BoardDelete;
import co.lsj.prj.board.serviceImpl.BoardInsert;
import co.lsj.prj.board.serviceImpl.BoardList;
import co.lsj.prj.board.serviceImpl.BoardSelect;
import co.lsj.prj.board.serviceImpl.BoardUpdate;
import co.lsj.prj.comm.Command;
import co.lsj.prj.comm.LogD;
import co.lsj.prj.member.serviceImpl.MemberDelete;
import co.lsj.prj.member.serviceImpl.MemberInsert;
import co.lsj.prj.member.serviceImpl.MemberList;
import co.lsj.prj.member.serviceImpl.MemberLogin;
import co.lsj.prj.member.serviceImpl.MemberSelect;
import co.lsj.prj.member.serviceImpl.MemberUpdate;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Command> map = new HashMap<String, Command>();

	public Menu() {
		map.put("boardList", new BoardList());
		map.put("boardSelect", new BoardSelect());
		map.put("boardInsert", new BoardInsert());
		map.put("boardUpdate", new BoardUpdate());
		map.put("boardDelete", new BoardDelete());

		map.put("memberList", new MemberList());
		map.put("memberSelect", new MemberSelect());
		map.put("memberInsert", new MemberInsert());
		map.put("memberUpdate", new MemberUpdate());
		map.put("memberDelete", new MemberDelete());

		// map.put("memberLogin", new MemberLogin());
	}

	private void startTitle() {
		MemberLogin login = new MemberLogin();
		login.execute();
		menu();
	}

	private void mainTitle() {
		System.out.println("=======================");
		System.out.println("======1. 멤버 관리 ======");
		System.out.println("======2. 공지 관리 ======");
		System.out.println("======3. 재 로그인 ======");
		System.out.println("======4. 종    료 ======");
		System.out.println("=======================");
		System.out.println("원하는 작업을 선택하세요.");
	}

	private void memberTitle() {
		System.out.println("=======================");
		System.out.println("====1. 회원목록 조회 ======");
		System.out.println("====2. 회원정보 조회 ======");
		System.out.println("====3. 회원정보 등록 ======");
		System.out.println("====4. 회원정보 수정 ======");
		System.out.println("====5. 회원정보 삭제 ======");
		System.out.println("====6. 메인메뉴 가기 ======");
		System.out.println("=======================");
		System.out.println("원하는 작업을 선택하세요.");
	}

	private void boardTitle() {
		System.out.println("=======================");
		System.out.println("====1. 공지사항 목록 ======");
		System.out.println("====2. 공지사항 조회 ======");
		System.out.println("====3. 공지사항 등록 ======");
		System.out.println("====4. 공지사항 수정 ======");
		System.out.println("====5. 공지사항 삭제 ======");
		System.out.println("====6. 메인메뉴 가기 ======");
		System.out.println("=======================");
		System.out.println("원하는 작업을 선택하세요.");
	}

	private void menu() {
		while (true) {
			mainTitle();
			int jobNo = sc.nextInt();
			if (jobNo == 1) {
				memberMagement();
				continue;
			} else if (jobNo == 2) {
				boardManagement();
				continue;
			} else if (jobNo == 3) {
				startTitle();
				continue;
			} else {
				System.out.println("Good bye~~~");
				LogD.scn.close();
				sc.close();
				break;
			}
		}

	}

	private void boardManagement() {
		boolean b = false;

		do {
			boardTitle();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				executeRun("boardList");
				break;
			case 2:
				executeRun("boardSelect");
				break;
			case 3:
				executeRun("boardInsert");
				break;
			case 4:
				executeRun("boardUpdate");
				break;
			case 5:
				executeRun("boardDelete");
				break;
			case 6:
				b = true;
				break;
			}
		} while (!b);

	}

	private void memberMagement() {
		boolean b = false;

		do {
			memberTitle();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				executeRun("memberList");
				break;
			case 2:
				executeRun("memberSelect");
				break;
			case 3:
				executeRun("memberInsert");
				break;
			case 4:
				executeRun("memberUpdate");
				break;
			case 5:
				executeRun("memberDelete");
				break;
			case 6:
				b = true;
				break;
			}
		} while (!b);

	}

	private void executeRun(String string) {
		// 실행할 명령을 구현한다.
		Command command = map.get(string);
		command.execute();
	}

	public void run() {
		startTitle();
	}
}
