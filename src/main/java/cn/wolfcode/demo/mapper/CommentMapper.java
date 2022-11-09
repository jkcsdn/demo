package cn.wolfcode.demo.mapper;

import cn.wolfcode.demo.entiy.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    /**
     *通过id查询对应的评论信息
     * @param id 游记id
     * @return 评论集合
     */
    List<Comment> queryListByArtId(@Param("id") Integer id,@Param("type") String type);

    /**
     *插入评论
     * @param comment 评论信息
     * @return 受影响行数
     */
    int insertComment(Comment comment);

    /**
     * 通过文章id查询评论数量
     * @param artId
     * @return
     */
    int queryContentByArtId(@Param("artId") Integer artId);

}
