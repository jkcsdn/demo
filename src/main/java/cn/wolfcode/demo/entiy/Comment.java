package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private String content;
    private Integer uid;
    private Integer artId;
    private String time;
    private String type;
    private User user; //评论人信息
}
