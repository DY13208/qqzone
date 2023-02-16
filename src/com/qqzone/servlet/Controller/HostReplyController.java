package com.qqzone.servlet.Controller;

import com.qqzone.pojo.HostReply;
import com.qqzone.pojo.Reply;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.HostReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author Alitar
 * @date 2023-02-15 19:28
 */
public class HostReplyController {
    private HostReplyService hostReplyService;
    public String addHostReply(String content,Integer reply_id,Integer reply_topic_id, HttpSession session){

        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply();
        reply.setId(reply_id);
        HostReply hostReply = new HostReply(content, LocalDateTime.now(),userBasic,reply);
        hostReplyService.addHostReply(hostReply);

        return "redirect:topic.do?operate=topicDetail&id="+reply_topic_id;

    }

}