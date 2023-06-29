package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtGoodsMapper;
import com.ruoyi.fantuan.domain.FtGoods;
import com.ruoyi.fantuan.service.IFtGoodsService;

/**
 * 菜品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtGoodsServiceImpl implements IFtGoodsService 
{
    @Autowired
    private FtGoodsMapper ftGoodsMapper;

    /**
     * 查询菜品管理
     * 
     * @param id 菜品管理主键
     * @return 菜品管理
     */
    @Override
    public FtGoods selectFtGoodsById(Long id)
    {
        return ftGoodsMapper.selectFtGoodsById(id);
    }

    /**
     * 查询菜品管理列表
     * 
     * @param ftGoods 菜品管理
     * @return 菜品管理
     */
    @Override
    public List<FtGoods> selectFtGoodsList(FtGoods ftGoods)
    {
        return ftGoodsMapper.selectFtGoodsList(ftGoods);
    }

    /**
     * 新增菜品管理
     * 
     * @param ftGoods 菜品管理
     * @return 结果
     */
    @Override
    public int insertFtGoods(FtGoods ftGoods)
    {
        ftGoods.setGoodsId(Uuid.getUUID());
        return ftGoodsMapper.insertFtGoods(ftGoods);
    }

    /**
     * 修改菜品管理
     * 
     * @param ftGoods 菜品管理
     * @return 结果
     */
    @Override
    public int updateFtGoods(FtGoods ftGoods)
    {
        return ftGoodsMapper.updateFtGoods(ftGoods);
    }

    /**
     * 批量删除菜品管理
     * 
     * @param ids 需要删除的菜品管理主键
     * @return 结果
     */
    @Override
    public int deleteFtGoodsByIds(Long[] ids)
    {
        return ftGoodsMapper.deleteFtGoodsByIds(ids);
    }

    /**
     * 删除菜品管理信息
     * 
     * @param id 菜品管理主键
     * @return 结果
     */
    @Override
    public int deleteFtGoodsById(Long id)
    {
        return ftGoodsMapper.deleteFtGoodsById(id);
    }
}
