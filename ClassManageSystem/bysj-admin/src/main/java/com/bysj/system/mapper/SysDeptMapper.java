package com.bysj.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bysj.system.domain.SysDept;

/**
 * 班级管理 数据层
 * 
 * @author bysj
 */
public interface SysDeptMapper
{
    /**
     * 查询班级人数
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int selectDeptCount(SysDept dept);

    /**
     * 查询班级是否存在用户
     * 
     * @param deptId 班级ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 查询班级管理数据
     * 
     * @param dept 班级信息
     * @return 班级信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 删除班级管理信息
     * 
     * @param deptId 班级ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改子元素关系
     * 
     * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * 根据班级ID查询信息
     * 
     * @param deptId 班级ID
     * @return 班级信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 校验班级名称是否唯一
     * 
     * @param deptName 班级名称
     * @param parentId 父班级ID
     * @return 结果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 根据角色ID查询班级
     *
     * @param roleId 角色ID
     * @return 班级列表
     */
    public List<String> selectRoleDeptTree(Long roleId);

    /**
     * 修改所在班级的父级班级状态
     * 
     * @param dept 班级
     */
    public void updateDeptStatus(SysDept dept);

    /**
     * 根据ID查询所有子班级
     * 
     * @param deptId 班级ID
     * @return 班级列表
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

    /**
     * 根据ID查询所有子班级（正常状态）
     * 
     * @param deptId 班级ID
     * @return 子班级数
     */
    public int selectNormalChildrenDeptById(Long deptId);
}
