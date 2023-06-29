package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtCouponMapper;
import com.ruoyi.fantuan.domain.FtCoupon;
import com.ruoyi.fantuan.service.IFtCouponService;

/**
 * 优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtCouponServiceImpl implements IFtCouponService 
{
    @Autowired
    private FtCouponMapper ftCouponMapper;

    /**
     * 查询优惠券
     * 
     * @param id 优惠券主键
     * @return 优惠券
     */
    @Override
    public FtCoupon selectFtCouponById(Long id)
    {
        return ftCouponMapper.selectFtCouponById(id);
    }

    /**
     * 查询优惠券列表
     * 
     * @param ftCoupon 优惠券
     * @return 优惠券
     */
    @Override
    public List<FtCoupon> selectFtCouponList(FtCoupon ftCoupon)
    {
        return ftCouponMapper.selectFtCouponList(ftCoupon);
    }

    /**
     * 新增优惠券
     * 
     * @param ftCoupon 优惠券
     * @return 结果
     */
    @Override
    public int insertFtCoupon(FtCoupon ftCoupon)
    {
        // 设置uuid
        ftCoupon.setCouponId(Uuid.getUUID());
        System.out.println(Uuid.getUUID()+"------111");
        return ftCouponMapper.insertFtCoupon(ftCoupon);
    }

    /**
     * 修改优惠券
     * 
     * @param ftCoupon 优惠券
     * @return 结果
     */
    @Override
    public int updateFtCoupon(FtCoupon ftCoupon)
    {
        return ftCouponMapper.updateFtCoupon(ftCoupon);
    }

    /**
     * 批量删除优惠券
     * 
     * @param ids 需要删除的优惠券主键
     * @return 结果
     */
    @Override
    public int deleteFtCouponByIds(Long[] ids)
    {
        return ftCouponMapper.deleteFtCouponByIds(ids);
    }

    /**
     * 删除优惠券信息
     * 
     * @param id 优惠券主键
     * @return 结果
     */
    @Override
    public int deleteFtCouponById(Long id)
    {
        return ftCouponMapper.deleteFtCouponById(id);
    }
}
