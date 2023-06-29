package com.ruoyi.fantuan.service;

import java.util.List;
import com.ruoyi.fantuan.domain.FtUser;

/**
 * 用户管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
public interface IFtUserService 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    public FtUser selectFtUserById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param ftUser 用户管理
     * @return 用户管理集合
     */
    public List<FtUser> selectFtUserList(FtUser ftUser);

    /**
     * 新增用户管理
     * 
     * @param ftUser 用户管理
     * @return 结果
     */
    public int insertFtUser(FtUser ftUser);

    /**
     * 修改用户管理
     * 
     * @param ftUser 用户管理
     * @return 结果
     */
    public int updateFtUser(FtUser ftUser);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteFtUserByIds(Long[] ids);

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    public int deleteFtUserById(Long id);
}
