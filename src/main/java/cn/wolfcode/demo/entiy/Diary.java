package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
    private Integer id; //主键id
    private String title; //标题
    private String abs; //介绍
    private String place; //位置
    private String cover; //封面
    private String content; //内容
    private Integer watch; //阅读量
    private String classify; //分类
    private Integer uid; //用户id
    private String goTime; //出发时间
    private Integer day; //花费时间
    private Double money; //花费金额
    private String accompany; //随行人员
    private Date writeTime; //书写时间
    private User user; //作者信息
    private String folder;//文件夹
    private List<Comment> commentList; //放对应游记里面的评论信息
    private Integer commentCount; //评论数
}
