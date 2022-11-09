package cn.wolfcode.demo.service.impl;

import cn.wolfcode.demo.entiy.HotSell;
import cn.wolfcode.demo.mapper.HotSellMapper;
import cn.wolfcode.demo.service.HotSellService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotSellServiceImpl implements HotSellService {

    @Resource
    HotSellMapper hotSellMapper;
    @Override
    public List<HotSell> getHotSellAll() {
        return hotSellMapper.getHotSellAll();
    }
}
