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
import com.ruoyi.fantuan.domain.FtShop;
import com.ruoyi.fantuan.service.IFtShopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 店铺管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/shop")
public class FtShopController extends BaseController
{
    @Autowired
    private IFtShopService ftShopService;

    /**
     * 查询店铺管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtShop ftShop)
    {
        startPage();
        List<FtShop> list = ftShopService.selectFtShopList(ftShop);
        return getDataTable(list);
    }

    /**
     * 导出店铺管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:export')")
    @Log(title = "店铺管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtShop ftShop)
    {
        List<FtShop> list = ftShopService.selectFtShopList(ftShop);
        ExcelUtil<FtShop> util = new ExcelUtil<FtShop>(FtShop.class);
        util.exportExcel(response, list, "店铺管理数据");
    }

    /**
     * 获取店铺管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftShopService.selectFtShopById(id));
    }

    /**
     * 新增店铺管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:add')")
    @Log(title = "店铺管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtShop ftShop)
    {
        return toAjax(ftShopService.insertFtShop(ftShop));
    }

    /**
     * 修改店铺管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:edit')")
    @Log(title = "店铺管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtShop ftShop)
    {
        return toAjax(ftShopService.updateFtShop(ftShop));
    }

    /**
     * 删除店铺管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:shop:remove')")
    @Log(title = "店铺管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftShopService.deleteFtShopByIds(ids));
    }
}
