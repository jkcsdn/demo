package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor  //带参构造方法
@NoArgsConstructor   //不带参构造方法
public class ResponseBean {
    private Integer code; //响应状态
    private String message; //消息
    private Object data; //数据
}
