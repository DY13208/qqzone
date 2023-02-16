package com.qqzone.dao;

import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-08 17:18
 */
public interface ReplyDao {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);
    //根据id获取指定的reply
    Reply getReply(Integer id);
}
