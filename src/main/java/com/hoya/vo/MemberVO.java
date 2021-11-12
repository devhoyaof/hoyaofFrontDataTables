package com.hoya.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberVO
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 1:27     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Getter @Setter
public class MemberVO {

	private String userid; // 회원아이디
	private String userpw; // 회원 비밀번호
	private String username; // 회원이름
	private String email; // 이메일
	private Date regdate; // 가입일자
	private Date updatedate; // 수정일자

	// getter, setter, toString() ...
}