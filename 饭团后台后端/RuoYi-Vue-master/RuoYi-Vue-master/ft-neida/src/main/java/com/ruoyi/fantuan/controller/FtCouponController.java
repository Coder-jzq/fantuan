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
import com.ruoyi.fantuan.domain.FtCoupon;
import com.ruoyi.fantuan.service.IFtCouponService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券Controller
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/fantuan/coupon")
public class FtCouponController extends BaseController
{
    @Autowired
    private IFtCouponService ftCouponService;

    /**
     * 查询优惠券列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:list')")
    @GetMapping("/list")
    public TableDataInfo list(FtCoupon ftCoupon)
    {
        startPage();
        List<FtCoupon> list = ftCouponService.selectFtCouponList(ftCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠券列表
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:export')")
    @Log(title = "优惠券", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FtCoupon ftCoupon)
    {
        List<FtCoupon> list = ftCouponService.selectFtCouponList(ftCoupon);
        ExcelUtil<FtCoupon> util = new ExcelUtil<FtCoupon>(FtCoupon.class);
        util.exportExcel(response, list, "优惠券数据");
    }

    /**
     * 获取优惠券详细信息
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ftCouponService.selectFtCouponById(id));
    }

    /**
     * 新增优惠券
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:add')")
    @Log(title = "优惠券", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FtCoupon ftCoupon)
    {
        return toAjax(ftCouponService.insertFtCoupon(ftCoupon));
    }

    /**
     * 修改优惠券
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:edit')")
    @Log(title = "优惠券", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FtCoupon ftCoupon)
    {
        return toAjax(ftCouponService.updateFtCoupon(ftCoupon));
    }

    /**
     * 删除优惠券
     */
    @PreAuthorize("@ss.hasPermi('fantuan:coupon:remove')")
    @Log(title = "优惠券", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ftCouponService.deleteFtCouponByIds(ids));
    }
}
