package com.ruoyi.fantuan.service;

import java.util.List;
import com.ruoyi.fantuan.domain.FtCoupon;

/**
 * 优惠券Service接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IFtCouponService 
{
    /**
     * 查询优惠券
     * 
     * @param id 优惠券主键
     * @return 优惠券
     */
    public FtCoupon selectFtCouponById(Long id);

    /**
     * 查询优惠券列表
     * 
     * @param ftCoupon 优惠券
     * @return 优惠券集合
     */
    public List<FtCoupon> selectFtCouponList(FtCoupon ftCoupon);

    /**
     * 新增优惠券
     * 
     * @param ftCoupon 优惠券
     * @return 结果
     */
    public int insertFtCoupon(FtCoupon ftCoupon);

    /**
     * 修改优惠券
     * 
     * @param ftCoupon 优惠券
     * @return 结果
     */
    public int updateFtCoupon(FtCoupon ftCoupon);

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的优惠券主键集合
     * @return 结果
     */
    public int deleteFtCouponByIds(Long[] ids);

    /**
     * 删除优惠券信息
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    public int deleteFtCouponById(Long id);
}
