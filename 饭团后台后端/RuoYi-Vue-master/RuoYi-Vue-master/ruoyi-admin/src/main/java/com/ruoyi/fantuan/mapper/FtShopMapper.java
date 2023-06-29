package com.ruoyi.fantuan.mapper;

import java.util.List;
import com.ruoyi.fantuan.domain.FtShop;

/**
 * 店铺管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface FtShopMapper 
{
    /**
     * 查询店铺管理
     * 
     * @param id 店铺管理主键
     * @return 店铺管理
     */
    public FtShop selectFtShopById(Long id);

    /**
     * 查询店铺管理列表
     * 
     * @param ftShop 店铺管理
     * @return 店铺管理集合
     */
    public List<FtShop> selectFtShopList(FtShop ftShop);

    /**
     * 新增店铺管理
     * 
     * @param ftShop 店铺管理
     * @return 结果
     */
    public int insertFtShop(FtShop ftShop);

    /**
     * 修改店铺管理
     * 
     * @param ftShop 店铺管理
     * @return 结果
     */
    public int updateFtShop(FtShop ftShop);

    /**
     * 删除店铺管理
     * 
     * @param id 店铺管理主键
     * @return 结果
     */
    public int deleteFtShopById(Long id);

    /**
     * 批量删除店铺管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFtShopByIds(Long[] ids);
}
