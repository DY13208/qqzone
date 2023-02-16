package com.qqzone.test;

import com.qqzone.dao.imp.UserBasicDaoImp;
import com.qqzone.pojo.UserBasic;
import org.junit.Test;

/**
 * @author Alitar
 * @date 2023-02-09 12:34
 */
public class testDao {
    @Test
    public void test1(){
        UserBasicDaoImp userBasicDAOImp = new UserBasicDaoImp();
        UserBasic userBasicId = userBasicDAOImp.getUserBasicId(3);
        System.out.println(userBasicId.getPwd());
    }
}