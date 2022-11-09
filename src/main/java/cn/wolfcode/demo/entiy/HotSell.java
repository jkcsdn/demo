package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotSell {
    //主键id
    private Integer id;
    //标题
    private String title;
    //价格
    private Double price;
    //图片
    private String img;
}
