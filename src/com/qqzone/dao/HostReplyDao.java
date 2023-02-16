package com.qqzone.dao;

import com.qqzone.pojo.HostReply;

/**
 * @author Alitar
 * @date 2023-02-08 17:21
 */
public interface HostReplyDao {
//根据ReplyId查询关联的HostRely实体
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
    void addHostReply(HostReply hostReply);
}
