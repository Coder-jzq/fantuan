package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtShopMapper;
import com.ruoyi.fantuan.domain.FtShop;
import com.ruoyi.fantuan.service.IFtShopService;

/**
 * 店铺管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtShopServiceImpl implements IFtShopService 
{
    @Autowired
    private FtShopMapper ftShopMapper;

    /**
     * 查询店铺管理
     * 
     * @param id 店铺管理主键
     * @return 店铺管理
     */
    @Override
    public FtShop selectFtShopById(Long id)
    {
        return ftShopMapper.selectFtShopById(id);
    }

    /**
     * 查询店铺管理列表
     * 
     * @param ftShop 店铺管理
     * @return 店铺管理
     */
    @Override
    public List<FtShop> selectFtShopList(FtShop ftShop)
    {
        return ftShopMapper.selectFtShopList(ftShop);
    }

    /**
     * 新增店铺管理
     * 
     * @param ftShop 店铺管理
     * @return 结果
     */
    @Override
    public int insertFtShop(FtShop ftShop)
    {
        ftShop.setShopId(Uuid.getUUID());
        return ftShopMapper.insertFtShop(ftShop);
    }

    /**
     * 修改店铺管理
     * 
     * @param ftShop 店铺管理
     * @return 结果
     */
    @Override
    public int updateFtShop(FtShop ftShop)
    {
        return ftShopMapper.updateFtShop(ftShop);
    }

    /**
     * 批量删除店铺管理
     * 
     * @param ids 需要删除的店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteFtShopByIds(Long[] ids)
    {
        return ftShopMapper.deleteFtShopByIds(ids);
    }

    /**
     * 删除店铺管理信息
     * 
     * @param id 店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteFtShopById(Long id)
    {
        return ftShopMapper.deleteFtShopById(id);
    }
}
