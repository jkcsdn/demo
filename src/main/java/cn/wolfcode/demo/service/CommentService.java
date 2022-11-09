package cn.wolfcode.demo.service;

import cn.wolfcode.demo.entiy.Comment;

public interface CommentService {
    /**
     *插入评论
     * @param comment
     * @return
     */
    int insertComment(Comment comment);
}
