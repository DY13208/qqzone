package com.qqzone.service;

import com.qqzone.pojo.HostReply;

/**
 * @author Alitar
 * @date 2023-02-11 19:30
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
    void addHostReply(HostReply hostReply);
}
