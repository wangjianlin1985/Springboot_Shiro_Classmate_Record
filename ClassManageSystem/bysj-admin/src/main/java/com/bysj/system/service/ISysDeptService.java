package com.bysj.system.service;

import java.util.List;
import com.bysj.common.core.domain.Ztree;
import com.bysj.system.domain.SysDept;
import com.bysj.system.domain.SysRole;

/**
 * 班级管理 服务层
 * 
 * @author bysj
 */
public interface ISysDeptService
{
    /**
     * 查询班级管理数据
     * 
     * @param dept 班级信息
     * @return 班级信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询班级管理树
     * 
     * @param dept 班级信息
     * @return 所有班级信息
     */
    public List<Ztree> selectDeptTree(SysDept dept);

    /**
     * 查询班级管理树（排除下级）
     * 
     * @param dept 班级信息
     * @return 所有班级信息
     */
    public List<Ztree> selectDeptTreeExcludeChild(SysDept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(SysRole role);

    /**
     * 查询班级人数
     * 
     * @param parentId 父班级ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询班级是否存在用户
     * 
     * @param deptId 班级ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除班级管理信息
     * 
     * @param deptId 班级ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 根据班级ID查询信息
     * 
     * @param deptId 班级ID
     * @return 班级信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子班级（正常状态）
     * 
     * @param deptId 班级ID
     * @return 子班级数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 校验班级名称是否唯一
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);
}
