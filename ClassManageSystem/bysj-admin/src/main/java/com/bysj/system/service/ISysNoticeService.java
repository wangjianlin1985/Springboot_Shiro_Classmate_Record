package com.bysj.system.service;

import java.util.List;
import com.bysj.system.domain.SysNotice;

/**
 * 留言 服务层
 * 
 * @author bysj
 */
public interface ISysNoticeService
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
     * 删除留言信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String ids);
}
