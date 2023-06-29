package com.ruoyi.fantuan.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fantuan.domain.FtUser;
import com.ruoyi.fantuan.service.IFtUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/user")
public class FtUserController extends BaseController
{
    @Autowired
    private IFtUserService ftUserService;

    /**
     * 查询用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtUser ftUser)
    {
        startPage();
        List<FtUser> list = ftUserService.selectFtUserList(ftUser);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:export')")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtUser ftUser)
    {
        List<FtUser> list = ftUserService.selectFtUserList(ftUser);
        ExcelUtil<FtUser> util = new ExcelUtil<FtUser>(FtUser.class);
        util.exportExcel(response, list, "用户管理数据");
    }

    /**
     * 获取用户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftUserService.selectFtUserById(id));
    }

    /**
     * 新增用户管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtUser ftUser)
    {
        return toAjax(ftUserService.insertFtUser(ftUser));
    }

    /**
     * 修改用户管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtUser ftUser)
    {
        return toAjax(ftUserService.updateFtUser(ftUser));
    }

    /**
     * 删除用户管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:user:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftUserService.deleteFtUserByIds(ids));
    }
}
