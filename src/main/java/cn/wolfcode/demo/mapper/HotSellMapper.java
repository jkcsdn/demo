package cn.wolfcode.demo.mapper;

import cn.wolfcode.demo.entiy.HotSell;

import java.util.List;

public interface HotSellMapper {
    /**
     *获取所有热卖信息
     * @return
     */
    List<HotSell> getHotSellAll();
}
