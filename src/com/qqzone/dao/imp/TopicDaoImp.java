package com.qqzone.dao.imp;

import com.qqzone.JDBCUtil.getDao;
import com.qqzone.dao.TopicDao;
import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-08 21:17
 */
public class TopicDaoImp extends getDao<Topic> implements TopicDao {
    @Override
    public List<Topic> getTopicBasic(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ? " , userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {
           executeUpdate("INSERT INTO t_topic VALUES(0,?,?,?,?);",topic.getTitle(),topic.getContent(),topic.getTopicDate(),topic.getAuthor().getId());
    }

    @Override
    public void delTopic(Topic topic) {
            executeUpdate("delete from t_topic where id=?",topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return load("select * from t_topic where id = ? ", id);
    }
}