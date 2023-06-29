package com.ruoyi.fantuan.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现管理对象 ft_cashout
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtCashout extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提现id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String cashoutId;

    /** 提现值 */
    @Excel(name = "提现值")
    private Long price;

    /** 提现商家 */
    @Excel(name = "提现商家")
    private String userId;

    /** 提现时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cashoutTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCashoutId(String cashoutId) 
    {
        this.cashoutId = cashoutId;
    }

    public String getCashoutId() 
    {
        return cashoutId;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCashoutTime(Date cashoutTime) 
    {
        this.cashoutTime = cashoutTime;
    }

    public Date getCashoutTime() 
    {
        return cashoutTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cashoutId", getCashoutId())
            .append("price", getPrice())
            .append("userId", getUserId())
            .append("cashoutTime", getCashoutTime())
            .toString();
    }
}
