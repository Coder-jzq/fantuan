package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtOrderMapper;
import com.ruoyi.fantuan.domain.FtOrder;
import com.ruoyi.fantuan.service.IFtOrderService;

/**
 * 订单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtOrderServiceImpl implements IFtOrderService 
{
    @Autowired
    private FtOrderMapper ftOrderMapper;

    /**
     * 查询订单管理
     * 
     * @param id 订单管理主键
     * @return 订单管理
     */
    @Override
    public FtOrder selectFtOrderById(Long id)
    {
        return ftOrderMapper.selectFtOrderById(id);
    }

    /**
     * 查询订单管理列表
     * 
     * @param ftOrder 订单管理
     * @return 订单管理
     */
    @Override
    public List<FtOrder> selectFtOrderList(FtOrder ftOrder)
    {
        return ftOrderMapper.selectFtOrderList(ftOrder);
    }

    /**
     * 新增订单管理
     * 
     * @param ftOrder 订单管理
     * @return 结果
     */
    @Override
    public int insertFtOrder(FtOrder ftOrder)
    {
        ftOrder.setOrderId(Uuid.getUUID());
        return ftOrderMapper.insertFtOrder(ftOrder);
    }

    /**
     * 修改订单管理
     * 
     * @param ftOrder 订单管理
     * @return 结果
     */
    @Override
    public int updateFtOrder(FtOrder ftOrder)
    {
        return ftOrderMapper.updateFtOrder(ftOrder);
    }

    /**
     * 批量删除订单管理
     * 
     * @param ids 需要删除的订单管理主键
     * @return 结果
     */
    @Override
    public int deleteFtOrderByIds(Long[] ids)
    {
        return ftOrderMapper.deleteFtOrderByIds(ids);
    }

    /**
     * 删除订单管理信息
     * 
     * @param id 订单管理主键
     * @return 结果
     */
    @Override
    public int deleteFtOrderById(Long id)
    {
        return ftOrderMapper.deleteFtOrderById(id);
    }
}
