package com.ruoyi.fantuan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠券对象 ft_coupon
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String couponId;

    /** 折扣额度 */
    @Excel(name = "折扣额度")
    private String discount;

    /** 校区 */
    @Excel(name = "校区")
    private String edu;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCouponId(String couponId) 
    {
        this.couponId = couponId;
    }

    public String getCouponId() 
    {
        return couponId;
    }
    public void setDiscount(String discount) 
    {
        this.discount = discount;
    }

    public String getDiscount() 
    {
        return discount;
    }
    public void setEdu(String edu) 
    {
        this.edu = edu;
    }

    public String getEdu() 
    {
        return edu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("couponId", getCouponId())
            .append("discount", getDiscount())
            .append("edu", getEdu())
            .toString();
    }
}
