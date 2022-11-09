package cn.wolfcode.demo.controller;

import cn.wolfcode.demo.entiy.*;
import cn.wolfcode.demo.service.HotSellService;
import cn.wolfcode.demo.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StrategyController {
    @Autowired
    StrategyService strategyService;
    @Autowired
    HotSellService hotSellService;

    @Value("${upload.imgurl}")
    private String imgUrl;

    @RequestMapping("/selectStrategyAll")
    @ResponseBody
    public ResponseBean selectStrategyAll(QueryObject queryObject){
        System.out.println(queryObject);
        //1.调用service层代码,获取所有攻略信息
        List<Strategy> strategies = strategyService.selectAll(queryObject);
        //2.查询所有热卖信息
        List<HotSell> hotSellAll = hotSellService.getHotSellAll();
        //3.响应数据
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(strategies);
        arrayList.add(hotSellAll);
        //返回响应信息
        if(strategies!=null){
            return new ResponseBean(200,"查询成功",arrayList);
        }else{
            return new ResponseBean(500,"查询失败",null);
        }
    }

    @RequestMapping("/queryStrategyById")
    @ResponseBody
    public ResponseBean queryStrategyById(Integer id){
        Strategy strategy = strategyService.queryStrategyById(id);
        return  new ResponseBean(200,"查询成功" , strategy);
    }

    @RequestMapping("/insertStrategy")
    @ResponseBody
    public ResponseBean insertStrategy(@RequestBody Strategy strategy) {
        int row = strategyService.insertStrategy(strategy);
        if (row > 0) {
            return new ResponseBean(200, "新增攻略成功", null);
        } else {
            return new ResponseBean(500, "新增攻略失败", null);
        }
    }

    /**
     *通过主键id删除对应的文件夹以及数据库数据
     * @param id 攻略的主键id
     * @return ResponseBean
     */
    @RequestMapping("/deleteStrategy")
    @ResponseBody
    public ResponseBean deleteDiary(Integer id){
        //1.删除文件夹
        //获取文件夹
        Strategy strategy = strategyService.queryStrategyById(id);
        //diary/1 需要添加E:/image/
        String folder = imgUrl + strategy.getFolder();
        //删除文件夹
        File file = new File(folder);
        //将里面文件都删除
        File[] files = file.listFiles();
        for(File file1:files){
            file1.delete();
        }
        file.delete();
        //2.删除数据库
        strategyService.deleteById(id);
        return new ResponseBean(200,"删除攻略成功" ,null);
    }

    @RequestMapping("/updateStrategy")
    @ResponseBody
    public  ResponseBean updateStrategy(@RequestBody Strategy strategy){
        //调用service
        int row = strategyService.updateStrategy(strategy);
        if(row>0) { return new ResponseBean(200,"更新攻略成功",null); }
        else { return new ResponseBean(500,"更新攻略失败",null); }
    }
}
