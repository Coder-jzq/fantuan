package com.ruoyi.fantuan.service;

import java.util.List;
import com.ruoyi.fantuan.domain.FtGoods;

/**
 * 菜品管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IFtGoodsService 
{
    /**
     * 查询菜品管理
     * 
     * @param id 菜品管理主键
     * @return 菜品管理
     */
    public FtGoods selectFtGoodsById(Long id);

    /**
     * 查询菜品管理列表
     * 
     * @param ftGoods 菜品管理
     * @return 菜品管理集合
     */
    public List<FtGoods> selectFtGoodsList(FtGoods ftGoods);

    /**
     * 新增菜品管理
     * 
     * @param ftGoods 菜品管理
     * @return 结果
     */
    public int insertFtGoods(FtGoods ftGoods);

    /**
     * 修改菜品管理
     * 
     * @param ftGoods 菜品管理
     * @return 结果
     */
    public int updateFtGoods(FtGoods ftGoods);

    /**
     * 批量删除菜品管理
     * 
     * @param ids 需要删除的菜品管理主键集合
     * @return 结果
     */
    public int deleteFtGoodsByIds(Long[] ids);

    /**
     * 删除菜品管理信息
     * 
     * @param id 菜品管理主键
     * @return 结果
     */
    public int deleteFtGoodsById(Long id);
}
