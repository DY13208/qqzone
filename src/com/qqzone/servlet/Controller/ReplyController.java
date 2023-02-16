package com.qqzone.servlet.Controller;

import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @author Alitar
 * @date 2023-02-12 22:50
 */
public class ReplyController {
    private ReplyService replyService;
    public String addReply(String content, Integer topicId,HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");

        Reply reply = new Reply(content, LocalDateTime.now(),author,new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
    public  String delReply(Integer replyId,Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}