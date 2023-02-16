package com.qqzone.dao;

import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-08 17:10
 */
public interface UserBasicDao {
    //根据账号id和密码获取指定用户信息
    public UserBasic getUserBasic(String loginId,String pwd);
    //获取指定用户的好友列表
    public List<UserBasic> getUserBasicList(UserBasic userBasic);
    //根据id查询用户
    public UserBasic getUserBasicId(Integer id);
}