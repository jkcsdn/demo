package cn.wolfcode.demo.mapper;

import cn.wolfcode.demo.entiy.Diary;
import cn.wolfcode.demo.entiy.QueryObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiaryMapper {

    /**
     *获取所有游记
     * @return
     */
    List<Diary> getDiaryAllByBasic(@Param("queryObject") QueryObject queryObject);

    /**
     *通过id查询对应的旅游日记
     * @param id 游记id
     * @return 游记信息
     */
    Diary queryById(Integer id);

    /**
     *通过游记id增加对应旅游的阅读量
     * @param id 游记
     * @return 受影响行数
     */
    int updateWatch(Integer id);
    /**
     *新增游记
     * @param diary 实体类
     * @return 受影响行数
     */
    int insertDiary(Diary diary);

    /**
     *通过游记id删除游记
     * @param id 游记id
     * @return 受影响行数
     */
    int deleteById(Integer id);

    /**
     *更新游记信息
     * @param diary 实体类
     * @return 受影响行数
     */
    int updateDiary(Diary diary);

    /**
     *获取热门城市前五名数据
     * @return
     */
    List<Diary> hotCity();

    /**
     *花费统计
     * @param num1
     * @param num2
     * @return
     */
    int countMoney(@Param("num1") Integer num1,@Param("num2") Integer num2);


}
