package com.qqzone.service;

import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-11 19:16
 */
public interface ReplyService {
    //根据topic的id获取所有关联的回复
    List<Reply> getReplyListByTopicId(Integer topicId);
    void addReply(Reply reply);
    //删除指定回复
    void delReply(Integer replyId);
    //删除指定的日志关联的所有会回复
    void delTopicList(Topic topic);

}
