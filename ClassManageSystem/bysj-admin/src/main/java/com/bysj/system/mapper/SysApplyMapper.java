package com.bysj.system.mapper;

import java.util.List;
import com.bysj.system.domain.SysApply;

/**
 * 班级申请Mapper接口
 * 
 * @author bysj
 * @date 2020-09-29
 */
public interface SysApplyMapper 
{
    /**
     * 查询班级申请
     * 
     * @param id 班级申请ID
     * @return 班级申请
     */
    public SysApply selectSysApplyById(Long id);

    /**
     * 查询班级申请列表
     * 
     * @param sysApply 班级申请
     * @return 班级申请集合
     */
    public List<SysApply> selectSysApplyList(SysApply sysApply);

    /**
     * 新增班级申请
     * 
     * @param sysApply 班级申请
     * @return 结果
     */
    public int insertSysApply(SysApply sysApply);

    /**
     * 修改班级申请
     * 
     * @param sysApply 班级申请
     * @return 结果
     */
    public int updateSysApply(SysApply sysApply);

    /**
     * 删除班级申请
     * 
     * @param id 班级申请ID
     * @return 结果
     */
    public int deleteSysApplyById(Long id);

    /**
     * 批量删除班级申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysApplyByIds(String[] ids);
}
