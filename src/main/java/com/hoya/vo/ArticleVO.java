package com.hoya.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : ArticleVO
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 3:15     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Getter
@Setter
public class ArticleVO {
	private Integer articleNo;

	private String title;

	private String content;

	private String writer;

	private Date regDate;

	private int viewCnt;
}
