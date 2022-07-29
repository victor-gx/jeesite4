package com.jeesite.modules.report.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.entity.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.report.entity.ReportOverUnderData;
import com.jeesite.modules.report.service.ReportOverUnderDataService;

/**
 * report_over_under_dataController
 * @author admin
 * @version 2022-07-27
 */
@Controller
@RequestMapping(value = "${adminPath}/report/reportOverUnderData")
public class ReportOverUnderDataController extends BaseController {

	@Autowired
	private ReportOverUnderDataService reportOverUnderDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ReportOverUnderData get(String id, boolean isNewRecord) {
		return reportOverUnderDataService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("report:reportOverUnderData:view")
	@RequestMapping(value = {"list", ""})
	public String list(ReportOverUnderData reportOverUnderData, Model model) {
		model.addAttribute("reportOverUnderData", reportOverUnderData);
		return "modules/report/reportOverUnderDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("report:reportOverUnderData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ReportOverUnderData> listData(ReportOverUnderData reportOverUnderData, HttpServletRequest request, HttpServletResponse response) {
		reportOverUnderData.setPage(new Page<>(request, response));
		Page<ReportOverUnderData> page = reportOverUnderDataService.findPage(reportOverUnderData);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("report:reportOverUnderData:view")
	@RequestMapping(value = "form")
	public String form(ReportOverUnderData reportOverUnderData, Model model) {
		model.addAttribute("reportOverUnderData", reportOverUnderData);
		return "modules/report/reportOverUnderDataForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("report:reportOverUnderData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ReportOverUnderData reportOverUnderData) {
		reportOverUnderDataService.save(reportOverUnderData);
		return renderResult(Global.TRUE, text("保存报表成功！"));
	}

	/**
	 * 停用报表
	 */
	@RequiresPermissions("report:reportOverUnderData:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ReportOverUnderData reportOverUnderData, HttpServletRequest request, HttpServletResponse response, Model model) {
		reportOverUnderData.setStatus(ReportOverUnderData.STATUS_DISABLE);
		reportOverUnderDataService.updateStatus(reportOverUnderData);
		return renderResult(Global.TRUE, text("停用报表''{0}''成功", reportOverUnderData.getReportNumber()));
	}

	/**
	 * 启用报表
	 */
	@RequiresPermissions("report:reportOverUnderData:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ReportOverUnderData reportOverUnderData, HttpServletRequest request, HttpServletResponse response, Model model) {
		reportOverUnderData.setStatus(ReportOverUnderData.STATUS_NORMAL);
		reportOverUnderDataService.updateStatus(reportOverUnderData);
		return renderResult(Global.TRUE, text("启用报表''{0}''成功", reportOverUnderData.getReportNumber()));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("report:reportOverUnderData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ReportOverUnderData reportOverUnderData) {
		reportOverUnderDataService.delete(reportOverUnderData);
		return renderResult(Global.TRUE, text("删除报表成功！"));
	}
	
}