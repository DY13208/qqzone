package com.qqzone.dao.imp;

import com.qqzone.JDBCUtil.getDao;
import com.qqzone.dao.UserBasicDao;
import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-08 17:21
 */
public class UserBasicDaoImp extends getDao<UserBasic> implements UserBasicDao {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select  * from t_user_basic where loginId = ? and pwd = ?",loginId,pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        //SELECT * FROM t_user_basic t1  LEFT JOIN t_friend t2 ON t1.id=t2.id  LIEF JOIN t_user_basic t3 ON t2.fid=t3.id
        String sql = "SELECT fid as id FROM t_friend WHERE uid=?";
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicId(Integer id) {
        return super.load("select * from t_user_basic where id = ?",id);
    }
}