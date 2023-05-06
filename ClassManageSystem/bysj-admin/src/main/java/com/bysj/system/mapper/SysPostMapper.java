package com.bysj.system.mapper;

import java.util.List;
import com.bysj.system.domain.SysPost;

/**
 * 班级职务信息 数据层
 * 
 * @author bysj
 */
public interface SysPostMapper
{
    /**
     * 查询班级职务数据集合
     * 
     * @param post 班级职务信息
     * @return 班级职务数据集合
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * 查询所有班级职务
     * 
     * @return 班级职务列表
     */
    public List<SysPost> selectPostAll();

    /**
     * 根据用户ID查询班级职务
     * 
     * @param userId 用户ID
     * @return 班级职务列表
     */
    public List<SysPost> selectPostsByUserId(Long userId);

    /**
     * 通过班级职务ID查询班级职务信息
     * 
     * @param postId 班级职务ID
     * @return 角色对象信息
     */
    public SysPost selectPostById(Long postId);

    /**
     * 批量删除班级职务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePostByIds(Long[] ids);

    /**
     * 修改班级职务信息
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public int updatePost(SysPost post);

    /**
     * 新增班级职务信息
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * 校验班级职务名称
     * 
     * @param postName 班级职务名称
     * @return 结果
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * 校验班级职务编码
     * 
     * @param postCode 班级职务编码
     * @return 结果
     */
    public SysPost checkPostCodeUnique(String postCode);
}
