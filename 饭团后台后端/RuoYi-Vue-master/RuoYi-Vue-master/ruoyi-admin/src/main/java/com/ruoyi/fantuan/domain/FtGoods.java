package com.ruoyi.fantuan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜品管理对象 ft_goods
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String img;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Long price;

    /** 商品状态 */
    @Excel(name = "商品状态")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String shopId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsId(String goodsId) 
    {
        this.goodsId = goodsId;
    }

    public String getGoodsId() 
    {
        return goodsId;
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
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsId", getGoodsId())
            .append("name", getName())
            .append("img", getImg())
            .append("price", getPrice())
            .append("status", getStatus())
            .append("shopId", getShopId())
            .toString();
    }
}
