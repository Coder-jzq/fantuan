package com.ruoyi.fantuan.service;

import java.util.List;
import com.ruoyi.fantuan.domain.FtOrder;

/**
 * 订单管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IFtOrderService 
{
    /**
     * 查询订单管理
     * 
     * @param id 订单管理主键
     * @return 订单管理
     */
    public FtOrder selectFtOrderById(Long id);

    /**
     * 查询订单管理列表
     * 
     * @param ftOrder 订单管理
     * @return 订单管理集合
     */
    public List<FtOrder> selectFtOrderList(FtOrder ftOrder);

    /**
     * 新增订单管理
     * 
     * @param ftOrder 订单管理
     * @return 结果
     */
    public int insertFtOrder(FtOrder ftOrder);

    /**
     * 修改订单管理
     * 
     * @param ftOrder 订单管理
     * @return 结果
     */
    public int updateFtOrder(FtOrder ftOrder);

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteFtOrderByIds(Long[] ids);

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理主键
     * @return 结果
     */
    public int deleteFtOrderById(Long id);
}
