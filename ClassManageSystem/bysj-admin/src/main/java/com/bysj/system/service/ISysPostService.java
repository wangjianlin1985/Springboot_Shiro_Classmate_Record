package com.bysj.system.service;

import java.util.List;
import com.bysj.system.domain.SysPost;

/**
 * 班级职务信息 服务层
 * 
 * @author bysj
 */
public interface ISysPostService
{
    /**
     * 查询班级职务信息集合
     * 
     * @param post 班级职务信息
     * @return 班级职务信息集合
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
     * @throws Exception 异常
     */
    public int deletePostByIds(String ids) throws Exception;

    /**
     * 新增保存班级职务信息
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * 修改保存班级职务信息
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public int updatePost(SysPost post);

    /**
     * 通过班级职务ID查询班级职务使用数量
     * 
     * @param postId 班级职务ID
     * @return 结果
     */
    public int countUserPostById(Long postId);

    /**
     * 校验班级职务名称
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public String checkPostNameUnique(SysPost post);

    /**
     * 校验班级职务编码
     * 
     * @param post 班级职务信息
     * @return 结果
     */
    public String checkPostCodeUnique(SysPost post);
}
