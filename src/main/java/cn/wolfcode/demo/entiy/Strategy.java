package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Strategy {
    private Integer id;
    private String abs;
    private String cover;
    private String place;
    private Integer watch;
    private Double price;
    private String title;
    //分类信息
    private String classify;
    private User user; //作者信息
    private String folder;//文件夹
    private String content; //内容
    private Integer uid; //用户id
}
