package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public Map<String, Object> selectChaptersByAlbumId(Integer page, Integer rows,String albumId) {
        Chapter chapter = new Chapter();
        chapter.setAlbumId(albumId);
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Chapter> chapters = chapterDao.selectByRowBounds(chapter, rowBounds);
        int count = chapterDao.selectCount(chapter);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("page",page);
        map.put("total",count%rows==0?count/rows:count/rows+1);
        map.put("rows",chapters);
        map.put("records",count);
        return map;
    }
}
