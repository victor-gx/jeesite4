package com.jeesite.modules.report.entity;

import javax.validation.constraints.Size;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * report_over_under_dataEntity
 * @author admin
 * @version 2022-07-27
 */
@Table(name="report_over_under_data", alias="a", label="report_over_under_data信息", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="stat_month", attrName="statMonth", label="日期"),
		@Column(name="report_number", attrName="reportNumber", label="报表"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ReportOverUnderData extends DataEntity<ReportOverUnderData> {
	
	private static final long serialVersionUID = 1L;
	private String statMonth;		// 日期
	private String reportNumber;		// 报表
	
	public ReportOverUnderData() {
		this(null);
	}
	
	public ReportOverUnderData(String id){
		super(id);
	}
	
	@Size(min=0, max=10, message="日期长度不能超过 10 个字符")
	public String getStatMonth() {
		return statMonth;
	}

	public void setStatMonth(String statMonth) {
		this.statMonth = statMonth;
	}
	
	@Size(min=0, max=10, message="报表长度不能超过 10 个字符")
	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	
}