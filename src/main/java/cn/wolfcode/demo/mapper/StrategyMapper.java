package cn.wolfcode.demo.mapper;

import cn.wolfcode.demo.entiy.Diary;
import cn.wolfcode.demo.entiy.QueryObject;
import cn.wolfcode.demo.entiy.Strategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyMapper {
    /**
    *查询所有旅游攻略信息
    * @return
    */
    List<Strategy> selectAll(@Param("queryObject") QueryObject queryObject);

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
