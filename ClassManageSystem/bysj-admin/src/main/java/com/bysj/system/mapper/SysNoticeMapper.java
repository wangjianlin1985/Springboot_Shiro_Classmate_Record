package com.bysj.system.mapper;

import java.util.List;
import com.bysj.system.domain.SysNotice;

/**
 * 留言 数据层
 * 
 * @author bysj
 */
public interface SysNoticeMapper
{
    /**
     * 查询留言信息
     * 
     * @param noticeId 留言ID
     * @return 留言信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询留言列表
     * 
     * @param notice 留言信息
     * @return 留言集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增留言
     * 
     * @param notice 留言信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改留言
     * 
     * @param notice 留言信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量删除留言
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);
}