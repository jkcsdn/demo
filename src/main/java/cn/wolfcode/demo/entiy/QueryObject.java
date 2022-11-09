package cn.wolfcode.demo.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryObject {
    //当前页，默认第一页
    private Integer currentPage=1;
    //容量，默认每页显示4条数据
    private Integer pageSiz=4;
    //最新或最热游记
    private String basic;
    //接收天数
    private Integer day;
    //接收金额
    private Double money;
    //分类信息
    private String classify;
}
