package com.qqzone.service.impl;

import com.qqzone.dao.ReplyDao;
import com.qqzone.pojo.HostReply;
import com.qqzone.pojo.Reply;
import com.qqzone.pojo.Topic;
import com.qqzone.pojo.UserBasic;
import com.qqzone.service.HostReplyService;
import com.qqzone.service.ReplyService;
import com.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author Alitar
 * @date 2023-02-11 19:23
 */
public class ReplyServiceImp implements ReplyService {
    private ReplyDao replyDao;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDao.getReplyList(new Topic(topicId));
        for (int i=0;i<replyList.size();i++){
            Reply reply = replyList.get(i);
            //将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //将关联的hostReply设置进去
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.addReply(reply);
    }

    @Override
    public void delReply(Integer replyId) {
        //1.根id获取到reply
        Reply reply = replyDao.getReply(replyId);
        if (reply!=null) {
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            // 2.如果reply有关联的hostReply. 则先册除hostReply
            if (hostReply!=null){
                hostReplyService.delHostReply(reply.getHostReply().getId());
            }
        }
        // 3.删除reply
        replyDao.delReply(replyId);
    }

    @Override
    public void delTopicList(Topic topic) {
        List<Reply> replyList = replyDao.getReplyList(topic);
        if (replyList!= null){
            for (Reply reply:replyList){
                delReply(reply.getId());
            }
        }
    }

}