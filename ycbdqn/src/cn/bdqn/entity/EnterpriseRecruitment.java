package cn.bdqn.entity;

import cn.bdqn.utils.FormatUtil;

public class EnterpriseRecruitment {

	private int id;		//
	private String title;		//企业名称
	private String content;	//企业介绍正文
	private Long time;			//时间日期
	private String source;		//来源
	private String createTimeView;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
		this.createTimeView = FormatUtil.formatDate(time);
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCreateTimeView() {
		return createTimeView;
	}
/*	public void setCreateTimeView(String createTimeView) {
		this.createTimeView = createTimeView;
	}
	*/
	
	
	
	
}
