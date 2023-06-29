package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtCashoutMapper;
import com.ruoyi.fantuan.domain.FtCashout;
import com.ruoyi.fantuan.service.IFtCashoutService;

/**
 * 提现管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtCashoutServiceImpl implements IFtCashoutService 
{
    @Autowired
    private FtCashoutMapper ftCashoutMapper;

    /**
     * 查询提现管理
     * 
     * @param id 提现管理主键
     * @return 提现管理
     */
    @Override
    public FtCashout selectFtCashoutById(Long id)
    {
        return ftCashoutMapper.selectFtCashoutById(id);
    }

    /**
     * 查询提现管理列表
     * 
     * @param ftCashout 提现管理
     * @return 提现管理
     */
    @Override
    public List<FtCashout> selectFtCashoutList(FtCashout ftCashout)
    {
        return ftCashoutMapper.selectFtCashoutList(ftCashout);
    }

    /**
     * 新增提现管理
     * 
     * @param ftCashout 提现管理
     * @return 结果
     */
    @Override
    public int insertFtCashout(FtCashout ftCashout)
    {
        ftCashout.setCashoutId(Uuid.getUUID());
        return ftCashoutMapper.insertFtCashout(ftCashout);
    }

    /**
     * 修改提现管理
     * 
     * @param ftCashout 提现管理
     * @return 结果
     */
    @Override
    public int updateFtCashout(FtCashout ftCashout)
    {
        return ftCashoutMapper.updateFtCashout(ftCashout);
    }

    /**
     * 批量删除提现管理
     * 
     * @param ids 需要删除的提现管理主键
     * @return 结果
     */
    @Override
    public int deleteFtCashoutByIds(Long[] ids)
    {
        return ftCashoutMapper.deleteFtCashoutByIds(ids);
    }

    /**
     * 删除提现管理信息
     * 
     * @param id 提现管理主键
     * @return 结果
     */
    @Override
    public int deleteFtCashoutById(Long id)
    {
        return ftCashoutMapper.deleteFtCashoutById(id);
    }
}
