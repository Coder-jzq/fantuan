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
import com.ruoyi.fantuan.domain.FtOrder;
import com.ruoyi.fantuan.service.IFtOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/order")
public class FtOrderController extends BaseController
{
    @Autowired
    private IFtOrderService ftOrderService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtOrder ftOrder)
    {
        startPage();
        List<FtOrder> list = ftOrderService.selectFtOrderList(ftOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:export')")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtOrder ftOrder)
    {
        List<FtOrder> list = ftOrderService.selectFtOrderList(ftOrder);
        ExcelUtil<FtOrder> util = new ExcelUtil<FtOrder>(FtOrder.class);
        util.exportExcel(response, list, "订单管理数据");
    }

    /**
     * 获取订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftOrderService.selectFtOrderById(id));
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtOrder ftOrder)
    {
        return toAjax(ftOrderService.insertFtOrder(ftOrder));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtOrder ftOrder)
    {
        return toAjax(ftOrderService.updateFtOrder(ftOrder));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:order:remove')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftOrderService.deleteFtOrderByIds(ids));
    }
}
