package com.ruoyi.fantuan.service.impl;

import java.util.List;

import com.ruoyi.fantuan.utils.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fantuan.mapper.FtUserMapper;
import com.ruoyi.fantuan.domain.FtUser;
import com.ruoyi.fantuan.service.IFtUserService;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-17
 */
@Service
public class FtUserServiceImpl implements IFtUserService 
{
    @Autowired
    private FtUserMapper ftUserMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    @Override
    public FtUser selectFtUserById(Long id)
    {
        return ftUserMapper.selectFtUserById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param ftUser 用户管理
     * @return 用户管理
     */
    @Override
    public List<FtUser> selectFtUserList(FtUser ftUser)
    {
        return ftUserMapper.selectFtUserList(ftUser);
    }

    /**
     * 新增用户管理
     * 
     * @param ftUser 用户管理
     * @return 结果
     */
    @Override
    public int insertFtUser(FtUser ftUser)
    {
        ftUser.setUserId(Uuid.getUUID());
        return ftUserMapper.insertFtUser(ftUser);
    }

    /**
     * 修改用户管理
     * 
     * @param ftUser 用户管理
     * @return 结果
     */
    @Override
    public int updateFtUser(FtUser ftUser)
    {
        return ftUserMapper.updateFtUser(ftUser);
    }

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteFtUserByIds(Long[] ids)
    {
        return ftUserMapper.deleteFtUserByIds(ids);
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteFtUserById(Long id)
    {
        return ftUserMapper.deleteFtUserById(id);
    }
}
