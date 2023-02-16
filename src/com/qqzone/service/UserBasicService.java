package com.qqzone.service;

import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-09 11:32
 */
public interface UserBasicService {
    //登录验证
    UserBasic login(String loginId,String pwd);
    //获取好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
    //根据id获取指定用户信息
    UserBasic getUserBasicById(Integer id);

}
