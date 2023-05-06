package com.bysj.system.service.impl;

import java.util.List;

import com.bysj.common.annotation.DataScope;
import com.bysj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bysj.system.mapper.SysApplyMapper;
import com.bysj.system.domain.SysApply;
import com.bysj.system.service.ISysApplyService;
import com.bysj.common.core.text.Convert;

/**
 * 班级申请Service业务层处理
 * 
 * @author bysj
 * @date 2020-09-29
 */
@Service
public class SysApplyServiceImpl implements ISysApplyService 
{
    @Autowired
    private SysApplyMapper sysApplyMapper;

    /**
     * 查询班级申请
     * 
     * @param id 班级申请ID
     * @return 班级申请
     */
    @Override
    public SysApply selectSysApplyById(Long id)
    {
        return sysApplyMapper.selectSysApplyById(id);
    }

    /**
     * 查询班级申请列表
     * 
     * @param sysApply 班级申请
     * @return 班级申请
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysApply> selectSysApplyList(SysApply sysApply)
    {
        return sysApplyMapper.selectSysApplyList(sysApply);
    }

    /**
     * 新增班级申请
     * 
     * @param sysApply 班级申请
     * @return 结果
     */
    @Override
    public int insertSysApply(SysApply sysApply)
    {
        sysApply.setCreateTime(DateUtils.getNowDate());
        return sysApplyMapper.insertSysApply(sysApply);
    }

    /**
     * 修改班级申请
     * 
     * @param sysApply 班级申请
     * @return 结果
     */
    @Override
    public int updateSysApply(SysApply sysApply)
    {
        sysApply.setUpdateTime(DateUtils.getNowDate());
        return sysApplyMapper.updateSysApply(sysApply);
    }

    /**
     * 删除班级申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysApplyByIds(String ids)
    {
        return sysApplyMapper.deleteSysApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级申请信息
     * 
     * @param id 班级申请ID
     * @return 结果
     */
    @Override
    public int deleteSysApplyById(Long id)
    {
        return sysApplyMapper.deleteSysApplyById(id);
    }
}
