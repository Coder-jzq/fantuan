package com.ruoyi.fantuan.mapper;

import java.util.List;
import com.ruoyi.fantuan.domain.FtCoupon;

/**
 * 优惠券Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface FtCouponMapper 
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
     * 删除优惠券
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    public int deleteFtCouponById(Long id);

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFtCouponByIds(Long[] ids);
}
