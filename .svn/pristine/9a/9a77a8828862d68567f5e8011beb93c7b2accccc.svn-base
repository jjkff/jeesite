/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test_audit.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * crudEntity
 * @author wgc
 * @version 2017-02-11
 */
public class Test_audit extends DataEntity<Test_audit> {
	
	private static final long serialVersionUID = 1L;
	private String procInsId;		// 流程实例ID
	private User user;		// 变动用户
	private Office office;		// 归属部门
	private String post;		// 岗位
	private String age;		// 性别
	private String edu;		// 学历
	private String content;		// 调整原因
	private String olda;		// 现行标准 薪酬档级
	private String oldb;		// 现行标准 月工资额
	private String oldc;		// 现行标准 年薪总额
	private String newa;		// 调整后标准 薪酬档级
	private String newb;		// 调整后标准 月工资额
	private String newc;		// 调整后标准 年薪总额
	private String addNum;		// 月增资
	private String exeDate;		// 执行时间
	private String hrText;		// 人力资源部门意见
	private String leadText;		// 分管领导意见
	private String mainLeadText;		// 集团主要领导意见
	
	public Test_audit() {
		super();
	}

	public Test_audit(String id){
		super(id);
	}

	@Length(min=0, max=64, message="流程实例ID长度必须介于 0 和 64 之间")
	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="岗位长度必须介于 0 和 255 之间")
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=255, message="学历长度必须介于 0 和 255 之间")
	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}
	
	@Length(min=0, max=255, message="调整原因长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=255, message="现行标准 薪酬档级长度必须介于 0 和 255 之间")
	public String getOlda() {
		return olda;
	}

	public void setOlda(String olda) {
		this.olda = olda;
	}
	
	@Length(min=0, max=255, message="现行标准 月工资额长度必须介于 0 和 255 之间")
	public String getOldb() {
		return oldb;
	}

	public void setOldb(String oldb) {
		this.oldb = oldb;
	}
	
	@Length(min=0, max=255, message="现行标准 年薪总额长度必须介于 0 和 255 之间")
	public String getOldc() {
		return oldc;
	}

	public void setOldc(String oldc) {
		this.oldc = oldc;
	}
	
	@Length(min=0, max=255, message="调整后标准 薪酬档级长度必须介于 0 和 255 之间")
	public String getNewa() {
		return newa;
	}

	public void setNewa(String newa) {
		this.newa = newa;
	}
	
	@Length(min=0, max=255, message="调整后标准 月工资额长度必须介于 0 和 255 之间")
	public String getNewb() {
		return newb;
	}

	public void setNewb(String newb) {
		this.newb = newb;
	}
	
	@Length(min=0, max=255, message="调整后标准 年薪总额长度必须介于 0 和 255 之间")
	public String getNewc() {
		return newc;
	}

	public void setNewc(String newc) {
		this.newc = newc;
	}
	
	@Length(min=0, max=255, message="月增资长度必须介于 0 和 255 之间")
	public String getAddNum() {
		return addNum;
	}

	public void setAddNum(String addNum) {
		this.addNum = addNum;
	}
	
	@Length(min=0, max=255, message="执行时间长度必须介于 0 和 255 之间")
	public String getExeDate() {
		return exeDate;
	}

	public void setExeDate(String exeDate) {
		this.exeDate = exeDate;
	}
	
	@Length(min=0, max=255, message="人力资源部门意见长度必须介于 0 和 255 之间")
	public String getHrText() {
		return hrText;
	}

	public void setHrText(String hrText) {
		this.hrText = hrText;
	}
	
	@Length(min=0, max=255, message="分管领导意见长度必须介于 0 和 255 之间")
	public String getLeadText() {
		return leadText;
	}

	public void setLeadText(String leadText) {
		this.leadText = leadText;
	}
	
	@Length(min=0, max=255, message="集团主要领导意见长度必须介于 0 和 255 之间")
	public String getMainLeadText() {
		return mainLeadText;
	}

	public void setMainLeadText(String mainLeadText) {
		this.mainLeadText = mainLeadText;
	}
	
}