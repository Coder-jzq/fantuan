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
import com.ruoyi.fantuan.domain.FtGoods;
import com.ruoyi.fantuan.service.IFtGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 菜品管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/goods")
public class FtGoodsController extends BaseController
{
    @Autowired
    private IFtGoodsService ftGoodsService;

    /**
     * 查询菜品管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtGoods ftGoods)
    {
        startPage();
        List<FtGoods> list = ftGoodsService.selectFtGoodsList(ftGoods);
        return getDataTable(list);
    }

    /**
     * 导出菜品管理列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:export')")
    @Log(title = "菜品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtGoods ftGoods)
    {
        List<FtGoods> list = ftGoodsService.selectFtGoodsList(ftGoods);
        ExcelUtil<FtGoods> util = new ExcelUtil<FtGoods>(FtGoods.class);
        util.exportExcel(response, list, "菜品管理数据");
    }

    /**
     * 获取菜品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftGoodsService.selectFtGoodsById(id));
    }

    /**
     * 新增菜品管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:add')")
    @Log(title = "菜品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtGoods ftGoods)
    {
        return toAjax(ftGoodsService.insertFtGoods(ftGoods));
    }

    /**
     * 修改菜品管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:edit')")
    @Log(title = "菜品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtGoods ftGoods)
    {
        return toAjax(ftGoodsService.updateFtGoods(ftGoods));
    }

    /**
     * 删除菜品管理
     */
    @PreAuthorize("@ss.hasPermi('fantuan:goods:remove')")
    @Log(title = "菜品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftGoodsService.deleteFtGoodsByIds(ids));
    }
}
