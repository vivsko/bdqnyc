package cn.bdqn.entity;


import cn.bdqn.utils.FormatUtil;

public class EmpStar {
	private Integer uuid;
	private String title;
	private String profile;
	private String content;
	private String picPath;
	private Long createTime;
	
	private String createTimeView;
	public String getCreateTimeView() {
		return createTimeView;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
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
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
		this.createTimeView = FormatUtil.formatDate(createTime);
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "EmpStar [uuid=" + uuid + ", title=" + title + ", profile=" + profile + ", content=" + content
				+ ", picPath=" + picPath + ", createTime=" + createTime + ", createTimeView=" + createTimeView + "]";
	}
	
	
	
	
}
