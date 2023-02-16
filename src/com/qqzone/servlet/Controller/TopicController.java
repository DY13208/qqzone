package com.qqzone.servlet.Controller;

import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.ReplyService;
import com.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-09 12:55
 */
public class TopicController {
    private TopicService topicService=null;

    public String topicDetail(Integer id, HttpSession session){
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        //从session获取当前用户信息
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        //再次查询当前用户关联的所有日志信息
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        //新覆一下friend中的信息(为什么不匿userbasic中?因为main.html页面选代的是friend这个key中的数据)
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
    public String addTopic(String title,String content,HttpSession session){

        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        Topic topic = new Topic(title,content,LocalDateTime.now(),userBasic);

        topicService.addTopic(topic);

        return "redirect:topic.do?operate=getTopicList";
    }
}