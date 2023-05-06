package com.bysj.system.service.impl;

import java.util.List;

import com.bysj.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bysj.common.core.text.Convert;
import com.bysj.system.domain.SysNotice;
import com.bysj.system.mapper.SysNoticeMapper;
import com.bysj.system.service.ISysNoticeService;

/**
 * 留言 服务层实现
 * 
 * @author bysj
 * @date 2018-06-25
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;

    /**
     * 查询留言信息
     * 
     * @param noticeId 留言ID
     * @return 留言信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询留言列表
     * 
     * @param notice 留言信息
     * @return 留言集合
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增留言
     * 
     * @param notice 留言信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改留言
     * 
     * @param notice 留言信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }
}
