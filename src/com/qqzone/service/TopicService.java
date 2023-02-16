package com.qqzone.service;

import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-09 12:47
 */
public interface TopicService {
    //查询特定用户的日子列表
    public List<Topic> getTopicList(UserBasic userBasic);
    //根据id获取特定topic
    public Topic getTopicById(Integer id);
    //根据id获取指定的author指定的topic信息，包括这个topic关注的作者信息
    public Topic getTopic(Integer id);
    //根据id删除指定topic
    void delTopic(Integer topicId);
    //增加新日志
    void addTopic(Topic topic);
}
