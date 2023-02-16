package com.qqzone.service.impl;

import com.qqzone.dao.UserBasicDao;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**'/
 * @author Alitar
 * @date 2023-02-09 11:33
 */
public class UserBasicServiceImp implements UserBasicService {
    private UserBasicDao userBasicDao ;
    @Override
    public UserBasic login(String loginId, String pwd) {

        return userBasicDao.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDao.getUserBasicList(userBasic);
        List<UserBasic> list = new ArrayList<>(userBasicList.size());
        for (int i = 0;i<userBasicList.size();i++){
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDao.getUserBasicId(friend.getId());
            list.add(friend);
        }
        return list;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {

        return userBasicDao.getUserBasicId(id);
    }
}