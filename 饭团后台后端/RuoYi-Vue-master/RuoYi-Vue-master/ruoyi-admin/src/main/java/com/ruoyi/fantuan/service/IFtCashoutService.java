package com.ruoyi.fantuan.service;

import java.util.List;
import com.ruoyi.fantuan.domain.FtCashout;

/**
 * 提现管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IFtCashoutService 
{
    /**
     * 查询提现管理
     * 
     * @param id 提现管理主键
     * @return 提现管理
     */
    public FtCashout selectFtCashoutById(Long id);

    /**
     * 查询提现管理列表
     * 
     * @param ftCashout 提现管理
     * @return 提现管理集合
     */
    public List<FtCashout> selectFtCashoutList(FtCashout ftCashout);

    /**
     * 新增提现管理
     * 
     * @param ftCashout 提现管理
     * @return 结果
     */
    public int insertFtCashout(FtCashout ftCashout);

    /**
     * 修改提现管理
     * 
     * @param ftCashout 提现管理
     * @return 结果
     */
    public int updateFtCashout(FtCashout ftCashout);

    /**
     * 批量删除提现管理
     * 
     * @param ids 需要删除的提现管理主键集合
     * @return 结果
     */
    public int deleteFtCashoutByIds(Long[] ids);

    /**
     * 删除提现管理信息
     * 
     * @param id 提现管理主键
     * @return 结果
     */
    public int deleteFtCashoutById(Long id);
}
