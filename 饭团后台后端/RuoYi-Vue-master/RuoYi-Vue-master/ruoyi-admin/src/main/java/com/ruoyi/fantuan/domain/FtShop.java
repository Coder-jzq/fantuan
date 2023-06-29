package com.ruoyi.fantuan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 店铺管理对象 ft_shop
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String shopId;

    /** 店铺名 */
    @Excel(name = "店铺名")
    private String name;

    /** 店铺图 */
    @Excel(name = "店铺图")
    private String img;

    /** 营业时间 */
    @Excel(name = "营业时间")
    private String openTime;

    /** 店铺公告 */
    @Excel(name = "店铺公告")
    private String notice;

    /** 商铺电话 */
    @Excel(name = "商铺电话")
    private String phone;

    /** 商家id */
    @Excel(name = "商家id")
    private String businessId;

    /** 第几餐厅 */
    @Excel(name = "第几餐厅")
    private String restaurant;

    /** 店铺状态 */
    @Excel(name = "店铺状态")
    private String status;

    /** 是否有团购资格 */
    @Excel(name = "是否有团购资格")
    private String groupFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setOpenTime(String openTime) 
    {
        this.openTime = openTime;
    }

    public String getOpenTime() 
    {
        return openTime;
    }
    public void setNotice(String notice) 
    {
        this.notice = notice;
    }

    public String getNotice() 
    {
        return notice;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBusinessId(String businessId) 
    {
        this.businessId = businessId;
    }

    public String getBusinessId() 
    {
        return businessId;
    }
    public void setRestaurant(String restaurant) 
    {
        this.restaurant = restaurant;
    }

    public String getRestaurant() 
    {
        return restaurant;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setGroupFlag(String groupFlag) 
    {
        this.groupFlag = groupFlag;
    }

    public String getGroupFlag() 
    {
        return groupFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("name", getName())
            .append("img", getImg())
            .append("openTime", getOpenTime())
            .append("notice", getNotice())
            .append("phone", getPhone())
            .append("businessId", getBusinessId())
            .append("restaurant", getRestaurant())
            .append("status", getStatus())
            .append("groupFlag", getGroupFlag())
            .toString();
    }
}
