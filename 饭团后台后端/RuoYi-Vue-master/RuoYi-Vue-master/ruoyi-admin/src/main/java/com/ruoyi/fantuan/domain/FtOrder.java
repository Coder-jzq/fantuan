package com.ruoyi.fantuan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单管理对象 ft_order
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String orderId;

    /** 用户外键 */
    @Excel(name = "用户外键")
    private String userId;

    /** 商家外键 */
    @Excel(name = "商家外键")
    private String businessId;

    /** 原价格 */
    @Excel(name = "原价格")
    private Long priceBegin;

    /** 优惠后价格 */
    @Excel(name = "优惠后价格")
    private Long priceEnd;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String status;

    /** 是否为团购 */
    @Excel(name = "是否为团购")
    private String isGroup;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 商品信息 */
    @Excel(name = "商品信息")
    private String goodsInfo;

    /** 付款人姓名 */
    @Excel(name = "付款人姓名")
    private String userName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setBusinessId(String businessId) 
    {
        this.businessId = businessId;
    }

    public String getBusinessId() 
    {
        return businessId;
    }
    public void setPriceBegin(Long priceBegin) 
    {
        this.priceBegin = priceBegin;
    }

    public Long getPriceBegin() 
    {
        return priceBegin;
    }
    public void setPriceEnd(Long priceEnd) 
    {
        this.priceEnd = priceEnd;
    }

    public Long getPriceEnd() 
    {
        return priceEnd;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setIsGroup(String isGroup) 
    {
        this.isGroup = isGroup;
    }

    public String getIsGroup() 
    {
        return isGroup;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setGoodsInfo(String goodsInfo) 
    {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodsInfo() 
    {
        return goodsInfo;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("priceBegin", getPriceBegin())
            .append("priceEnd", getPriceEnd())
            .append("status", getStatus())
            .append("isGroup", getIsGroup())
            .append("orderNumber", getOrderNumber())
            .append("orderTime", getOrderTime())
            .append("goodsInfo", getGoodsInfo())
            .append("userName", getUserName())
            .toString();
    }
}
