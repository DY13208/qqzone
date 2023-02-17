package com.qqzone.dao.imp;

import com.qqzone.mySpringMvc.JDBCUtil.getDao;
import com.qqzone.dao.HostReplyDao;
import com.qqzone.pojo.HostReply;

/**
 * @author Alitar
 * @date 2023-02-11 19:33
 */
public class HostReplyDaoImp extends getDao<HostReply> implements HostReplyDao {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return super.load("SELECT * FROM t_host_reply WHERE reply = ?",replyId);
    }

    @Override
    public void delHostReply(Integer id) {
         executeUpdate("delete from t_host_reply where id = ?",id);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        executeUpdate("insert into t_host_reply values(0,?,?,?,?)",hostReply.getContent(),hostReply.getHostReplyDate(),hostReply.getAuthor().getId(),hostReply.getReply().getId());
    }
}