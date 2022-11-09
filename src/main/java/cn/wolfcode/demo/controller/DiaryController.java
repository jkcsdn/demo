package cn.wolfcode.demo.controller;

import cn.wolfcode.demo.entiy.Diary;
import cn.wolfcode.demo.entiy.EchartsObject;
import cn.wolfcode.demo.entiy.QueryObject;
import cn.wolfcode.demo.entiy.ResponseBean;
import cn.wolfcode.demo.service.DiaryService;
import com.github.pagehelper.PageInfo;
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
public class DiaryController {

    @Value("${upload.imgurl}")
    private String imgUrl;
    @Autowired
    DiaryService diaryService; //注入service

    @RequestMapping("/getDiaryByBasic")
    @ResponseBody
    public ResponseBean getDiaryByBasic(QueryObject queryObject) {
        //调用service方法
        PageInfo<Diary> diaryAll = diaryService.getDiaryAllByBasic(queryObject);
        //返回响应数据
            return new ResponseBean(200, "查询旅游日志成功", diaryAll);
        }

    @RequestMapping("/queryDiaryById")
    @ResponseBody
    public ResponseBean queryDiaryById(Integer id){
        //调用service
        Diary diary = diaryService.queryById(id);
        //返回数据
        return  new ResponseBean(200,"查询成功" , diary);
    }

    @RequestMapping("/insertDiary")
    @ResponseBody
    public ResponseBean insertDiary(@RequestBody Diary diary) {
        int row = diaryService.insertDiary(diary);
        if (row > 0) {
            return new ResponseBean(200, "新增旅游日志成功", null);
        } else {
            return new ResponseBean(500, "新增旅游日志失败", null);
        }
    }

    /**
    *通过主键id删除对应的文件夹以及数据库数据
    * @param id 游记的主键id
    * @return ResponseBean
    */

    @RequestMapping("/deleteDiary")
    @ResponseBody
    public ResponseBean deleteDiary(Integer id){
        //1.删除文件夹
            //获取文件夹
            Diary diary = diaryService.queryById(id);
            //diary/1 需要添加E:/image/
            String folder = imgUrl + diary.getFolder();
            //删除文件夹
            File file = new File(folder);
            //将里面文件都删除
            File[] files = file.listFiles();
            for(File file1:files){
                file1.delete();
            }
            file.delete();
        //2.删除数据库
        diaryService.deleteById(id);
        return new ResponseBean(200,"删除游记成功" ,null);
    }

    @RequestMapping("/updateDiary")
    @ResponseBody
    public  ResponseBean updateDiary(@RequestBody Diary diary){
        //调用service
        int row = diaryService.updateDiary(diary);
        if(row>0) { return new ResponseBean(200,"更新游记成功",null); }
        else { return new ResponseBean(500,"更新游记失败",null); }
    }

    @RequestMapping("/hotCity")
    @ResponseBody
    public ResponseBean hotCity(){
    List<Diary> diaries = diaryService.hotCity();
    return new ResponseBean(200,"响应成功" ,diaries);
    }

    @RequestMapping("/countMoney")
    @ResponseBody
    public ResponseBean countMoney(){
        EchartsObject echartsObject1 = new EchartsObject(50000,null);
        EchartsObject echartsObject2 = new EchartsObject(40000,50000);
        EchartsObject echartsObject3 = new EchartsObject(30000,40000);
        EchartsObject echartsObject4 = new EchartsObject(10000,30000);
        EchartsObject echartsObject5 = new EchartsObject(1,10000);
        //集合存着5个实体类
        ArrayList<EchartsObject> arrayList = new ArrayList<>();
        arrayList.add(echartsObject1);
        arrayList.add(echartsObject2);
        arrayList.add(echartsObject3);
        arrayList.add(echartsObject4);
        arrayList.add(echartsObject5);

        //创建一个存花费数据的集合
        ArrayList result = new ArrayList();
        //遍历每一个EchartsObject的实体类
        for(EchartsObject obj:arrayList){
            int count = diaryService.countMoney(obj.getNum1(),obj.getNum2());
            result.add(count);
        }
        return new ResponseBean(200,"查询花费统计成功",result);
    }



}
