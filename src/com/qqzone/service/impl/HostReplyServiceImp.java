package com.qqzone.service.impl;

import com.qqzone.dao.HostReplyDao;
import com.qqzone.pojo.HostReply;
import com.qqzone.service.HostReplyService;

/**
 * @author Alitar
 * @date 2023-02-11 19:31
 */
public class HostReplyServiceImp implements HostReplyService {
    private HostReplyDao hostReplyDao;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {

        return hostReplyDao.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
            hostReplyDao.delHostReply(id);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
            hostReplyDao.addHostReply(hostReply);
    }
}