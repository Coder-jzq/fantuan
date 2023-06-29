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
import com.ruoyi.fantuan.domain.FtCashout;
import com.ruoyi.fantuan.service.IFtCashoutService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/cashout")
public class FtCashoutController extends BaseController
{
    @Autowired
    private IFtCashoutService ftCashoutService;

    /**
     * 查询提现管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtCashout ftCashout)
    {
        startPage();
        List<FtCashout> list = ftCashoutService.selectFtCashoutList(ftCashout);
        return getDataTable(list);
    }

    /**
     * 导出提现管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:export')")
    @Log(title = "提现管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtCashout ftCashout)
    {
        List<FtCashout> list = ftCashoutService.selectFtCashoutList(ftCashout);
        ExcelUtil<FtCashout> util = new ExcelUtil<FtCashout>(FtCashout.class);
        util.exportExcel(response, list, "提现管理数据");
    }

    /**
     * 获取提现管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftCashoutService.selectFtCashoutById(id));
    }

    /**
     * 新增提现管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:add')")
    @Log(title = "提现管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtCashout ftCashout)
    {
        return toAjax(ftCashoutService.insertFtCashout(ftCashout));
    }

    /**
     * 修改提现管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:edit')")
    @Log(title = "提现管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtCashout ftCashout)
    {
        return toAjax(ftCashoutService.updateFtCashout(ftCashout));
    }

    /**
     * 删除提现管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:cashout:remove')")
    @Log(title = "提现管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftCashoutService.deleteFtCashoutByIds(ids));
    }
}
