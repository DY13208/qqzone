package com.qqzone.servlet.Controller;

import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.TopicService;
import com.qqzone.service.UserBasicService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-09 12:55
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;
    public String login(String loginId, String pwd, HttpSession session){
        //登陆验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic!=null){
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic这个key保存的是登录的信息
            // friend这个key保存的是当前进入的是谁的空间
            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
                return "index";
        }else {
            return "login";
        }

    }
    public String friend(Integer id,HttpSession session){

            //根据id获取指定的用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);

        currFriend.setTopicList(topicList);

        session.setAttribute("friend",currFriend);

        return "index";
    }
}