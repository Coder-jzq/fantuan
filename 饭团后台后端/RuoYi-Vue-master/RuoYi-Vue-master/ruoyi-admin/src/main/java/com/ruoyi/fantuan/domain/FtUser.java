package com.ruoyi.fantuan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 ft_user
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public class FtUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** uuid */
    @Excel(name = "uuid")
    private String userId;

    /** 账号 */
    @Excel(name = "账号")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 昵称 */
    @Excel(name = "昵称")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 学校 */
    @Excel(name = "学校")
    private String edu;

    /** 权限 */
    @Excel(name = "权限")
    private String power;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String faceImg;

    /** 账号状态 */
    @Excel(name = "账号状态")
    private String status;

    /** openid */
    @Excel(name = "openid")
    private String openid;

    /** 商家用户可持有店铺数量 */
    @Excel(name = "商家用户可持有店铺数量")
    private Long shopNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEdu(String edu) 
    {
        this.edu = edu;
    }

    public String getEdu() 
    {
        return edu;
    }
    public void setPower(String power) 
    {
        this.power = power;
    }

    public String getPower() 
    {
        return power;
    }
    public void setFaceImg(String faceImg) 
    {
        this.faceImg = faceImg;
    }

    public String getFaceImg() 
    {
        return faceImg;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setShopNum(Long shopNum) 
    {
        this.shopNum = shopNum;
    }

    public Long getShopNum() 
    {
        return shopNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("name", getName())
            .append("phone", getPhone())
            .append("edu", getEdu())
            .append("power", getPower())
            .append("faceImg", getFaceImg())
            .append("status", getStatus())
            .append("openid", getOpenid())
            .append("shopNum", getShopNum())
            .toString();
    }
}
