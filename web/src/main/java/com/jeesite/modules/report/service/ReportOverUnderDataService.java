package com.jeesite.modules.report.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.report.entity.ReportOverUnderData;
import com.jeesite.modules.report.dao.ReportOverUnderDataDao;

/**
 * report_over_under_dataService
 * @author admin
 * @version 2022-07-27
 */
@Service
@Transactional(readOnly=true)
public class ReportOverUnderDataService extends CrudService<ReportOverUnderDataDao, ReportOverUnderData> {
	
	/**
	 * 获取单条数据
	 * @param reportOverUnderData
	 * @return
	 */
	@Override
	public ReportOverUnderData get(ReportOverUnderData reportOverUnderData) {
		return super.get(reportOverUnderData);
	}
	
	/**
	 * 查询分页数据
	 * @param reportOverUnderData 查询条件
	 * @param reportOverUnderData.page 分页对象
	 * @return
	 */
	@Override
	public Page<ReportOverUnderData> findPage(ReportOverUnderData reportOverUnderData) {
		return super.findPage(reportOverUnderData);
	}
	
	/**
	 * 查询列表数据
	 * @param reportOverUnderData
	 * @return
	 */
	@Override
	public List<ReportOverUnderData> findList(ReportOverUnderData reportOverUnderData) {
		return super.findList(reportOverUnderData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param reportOverUnderData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ReportOverUnderData reportOverUnderData) {
		super.save(reportOverUnderData);
	}
	
	/**
	 * 更新状态
	 * @param reportOverUnderData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ReportOverUnderData reportOverUnderData) {
		super.updateStatus(reportOverUnderData);
	}
	
	/**
	 * 删除数据
	 * @param reportOverUnderData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ReportOverUnderData reportOverUnderData) {
		super.delete(reportOverUnderData);
	}
	
}