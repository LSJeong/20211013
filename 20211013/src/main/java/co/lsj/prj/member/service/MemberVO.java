package co.lsj.prj.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String tel;
	private String address;
	private String author;
}
