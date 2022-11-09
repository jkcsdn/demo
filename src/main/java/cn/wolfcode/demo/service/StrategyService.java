package cn.wolfcode.demo.service;

import cn.wolfcode.demo.entiy.QueryObject;
import cn.wolfcode.demo.entiy.Strategy;

import java.util.List;

public interface StrategyService {
    /**
    *查询所有旅游攻略
    * @return
    */
    List<Strategy> selectAll(QueryObject queryObject);

    /**
     *通过id查询对应的攻略信息
     * @param id 攻略id
     * @return 攻略信息
     */
    Strategy queryStrategyById(Integer id);

    /**
     *新增攻略
     * @param strategy 实体类
     * @return 受影响行数
     */
    int insertStrategy(Strategy strategy);

    /**
     *通过游记id删除攻略
     * @param id 攻略id
     * @return 受影响行数
     */
    int deleteById(Integer id);

    /**
     *更新攻略信息
     * @param strategy 实体类
     * @return 受影响行数
     */
    int updateStrategy(Strategy strategy);

}
