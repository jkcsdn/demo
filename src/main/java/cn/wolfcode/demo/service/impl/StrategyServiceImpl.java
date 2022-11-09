package cn.wolfcode.demo.service.impl;

import cn.wolfcode.demo.entiy.QueryObject;
import cn.wolfcode.demo.entiy.Strategy;
import cn.wolfcode.demo.mapper.StrategyMapper;
import cn.wolfcode.demo.service.StrategyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Resource
    StrategyMapper strategyMapper;
    @Override
    public List<Strategy> selectAll(QueryObject queryObject) {
        System.out.println(queryObject);
        //调用mapper查询攻略信息
        return strategyMapper.selectAll(queryObject);
    }

    @Override
    public Strategy queryStrategyById(Integer id) {
        return strategyMapper.queryStrategyById(id);
    }

    @Override
    public int insertStrategy(Strategy strategy) {
        int row = strategyMapper.insertStrategy(strategy);
        return row;
    }

    @Override
    public int deleteById(Integer id) {
        return strategyMapper.deleteById(id);
    }

    @Override
    public int updateStrategy(Strategy strategy) {
        return strategyMapper.updateStrategy(strategy);
    }

}
