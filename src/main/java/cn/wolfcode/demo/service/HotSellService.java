package cn.wolfcode.demo.service;

import cn.wolfcode.demo.entiy.HotSell;

import java.util.List;

public interface HotSellService {
    /**
    *获取所有热卖信息
    * @return
    */
    List<HotSell> getHotSellAll();
}
