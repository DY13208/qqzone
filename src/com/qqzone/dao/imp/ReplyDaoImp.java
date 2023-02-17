package com.qqzone.dao.imp;

import com.qqzone.mySpringMvc.JDBCUtil.getDao;
import com.qqzone.dao.ReplyDao;
import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-11 19:37
 */
public class ReplyDaoImp extends getDao<Reply> implements ReplyDao {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return executeQuery("select * from t_reply where topic = ?",topic.getId());
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0,?,?,?,?)",reply.getContent(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getTopic().getId());

    }

    @Override
    public void delReply(Integer id) {
        executeUpdate("delete from t_reply where id = ? ",id);

    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id= ?",id);
    }
}