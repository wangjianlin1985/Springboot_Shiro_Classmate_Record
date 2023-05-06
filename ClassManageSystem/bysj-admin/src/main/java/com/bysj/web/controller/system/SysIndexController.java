package com.bysj.web.controller.system;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bysj.system.domain.SysDept;
import com.bysj.system.domain.SysNotice;
import com.bysj.system.service.ISysDeptService;
import com.bysj.system.service.ISysNoticeService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bysj.common.config.Global;
import com.bysj.common.core.controller.BaseController;
import com.bysj.common.utils.CookieUtils;
import com.bysj.common.utils.ServletUtils;
import com.bysj.common.utils.StringUtils;
import com.bysj.framework.util.ShiroUtils;
import com.bysj.system.domain.SysMenu;
import com.bysj.system.domain.SysUser;
import com.bysj.system.service.ISysConfigService;
import com.bysj.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author bysj
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysConfigService configService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
        mmap.put("ignoreFooter", configService.selectConfigByKey("sys.index.ignoreFooter"));
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());

        // 菜单导航显示风格
        String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
        // 移动端，默认使左侧导航菜单，否则取默认配置
        String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index" : menuStyle;

        // 优先Cookie配置导航菜单
        Cookie[] cookies = ServletUtils.getRequest().getCookies();
        for (Cookie cookie : cookies)
        {
            if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName()))
            {
                indexStyle = cookie.getValue();
                break;
            }
        }
        String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
        return webIndex;
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin()
    {
        return "skin";
    }

    // 切换菜单
    @GetMapping("/system/menuStyle/{style}")
    public void menuStyle(@PathVariable String style, HttpServletResponse response)
    {
        CookieUtils.setCookie(response, "nav-style", style);
    }

    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private ISysNoticeService noticeService;

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        mmap.put("user", ShiroUtils.getSysUser());

        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);

        SysNotice notice=new SysNotice();
        if(!ShiroUtils.getSysUser().isAdmin()){
            notice.setDeptId(ShiroUtils.getSysUser().getDept().getDeptId());
            if(ShiroUtils.getSysUser().getDept().getDeptId()==null){
                notice.setDeptId(0L);
            }
        }
        notice.setCreateBy(ShiroUtils.getLoginName());
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        JSONArray array=new JSONArray();
        for (SysNotice item:list) {

            JSONObject json=(JSONObject)JSONObject.toJSON(item);
            json.put("createTime",DateFormatUtils.format(item.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            array.add(json);
        }
        mmap.put("noticeList", array);
        return "main";
    }
}
