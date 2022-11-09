package cn.wolfcode.demo.service.impl;

import cn.wolfcode.demo.entiy.Comment;
import cn.wolfcode.demo.entiy.Diary;
import cn.wolfcode.demo.entiy.QueryObject;
import cn.wolfcode.demo.mapper.CommentMapper;
import cn.wolfcode.demo.mapper.DiaryMapper;
import cn.wolfcode.demo.service.DiaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class DiaryServiceImpl implements DiaryService {
    @Resource
    DiaryMapper diaryMapper;
    @Resource
    CommentMapper commentMapper;

    @Override
    public PageInfo<Diary> getDiaryAllByBasic(QueryObject queryObject) {
        //1.设置信息，告诉PageHelper当前页数和容量
        PageHelper.startPage(queryObject.getCurrentPage(),queryObject.getPageSiz());
        //查询所有的游记数据
        List<Diary> diaryAllByBasic = diaryMapper.getDiaryAllByBasic(queryObject);
        //返回分页后的数据
            return new PageInfo<>(diaryAllByBasic);
    }

    @Override
    public Diary queryById(Integer id) {
        //阅读量加一
        diaryMapper.updateWatch(id);
        //查询游记信息
        Diary diary = diaryMapper.queryById(id);
        //查询评论
        List<Comment> comments = commentMapper.queryListByArtId(id,"0");
        //设置在diary
        diary.setCommentList(comments);
        //返回数据
        return diary;
    }

    @Override
    public int insertDiary(Diary diary) {
        //生成当前时间并格式为2022-07-14 16：41：11的格式
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        diary.setWriteTime(date);
        //调用mapper,返回受影响行数
        int row = diaryMapper.insertDiary(diary);
        return row;

    }

    @Override
    public int deleteById(Integer id) {
        return diaryMapper.deleteById(id);
    }

    @Override
    public int updateDiary(Diary diary) {
        return diaryMapper.updateDiary(diary);
    }

    @Override
    public List<Diary> hotCity() {
        return diaryMapper.hotCity();
    }

    @Override
    public int countMoney(Integer num1, Integer num2) {

        return diaryMapper.countMoney(num1,num2);
    }

}
