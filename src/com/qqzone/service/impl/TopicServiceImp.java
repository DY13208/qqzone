package com.qqzone.service.impl;

import com.qqzone.dao.TopicDao;
import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.ReplyService;
import com.qqzone.service.TopicService;
import com.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-09 12:48
 */
public class TopicServiceImp implements TopicService {
    private TopicDao topicDao ;
    private ReplyService replyService ;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {

        return topicDao.getTopicBasic(userBasic);
    }

    //根据id获取指定的author指定的topic信息，包括这个topic关注的作者信息
    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDao.getTopic(id);
        UserBasic author = topic.getAuthor();
        author   = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;

    }
    //根据id删除日志
    @Override
    public void delTopic(Integer topicId) {
        Topic topic = topicDao.getTopic(topicId);
        if (topic!=null) {
            replyService.delTopicList(topic);
            topicDao.delTopic(topic);
        }
    }


    //根据id获取topic和replyList
    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList= replyService.getReplyListByTopicId(topic.getId());
        topic.setReplies(replyList);
        return topic;
    }
    //增加新日志
    @Override
    public void addTopic(Topic topic) {
        if (topic!=null){
            topicDao.addTopic(topic);
        }
    }
}