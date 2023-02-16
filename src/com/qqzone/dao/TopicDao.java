package com.qqzone.dao;

import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-08 17:14
 */
public interface TopicDao {
    //获取指定用户的日志列表
    public List<Topic> getTopicBasic(UserBasic userBasic);
    //添加日志
    public void addTopic(Topic topic);
    //删除日志
    public void  delTopic(Topic topic);
    //获取特定日志的超链接
    public Topic getTopic(Integer id);
}
