package com.hoya.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : Search
 * date : 2021-11-05
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-05   오후 3:32     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Setter
@Getter
public class Search {

	Integer[] ids;

	private Integer articleNo;
	private String title;
	private String content;
	private String writer;
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+9", pattern = "yyyy-MM-dd HH:mm")
	private Date regDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+9", pattern = "yyyy-MM-dd HH:mm")
	private Date modDttm;
	private int viewCnt;
	private String delYn;
}
