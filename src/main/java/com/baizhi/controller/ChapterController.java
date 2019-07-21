package com.baizhi.controller;

import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("chapter")
@RestController
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("selectChaptersByAlbumId")
    public Map<String,Object> selectChaptersByAlbumId(Integer page,Integer rows,String albumId){
        Map<String, Object> map = chapterService.selectChaptersByAlbumId(page, rows, albumId);
        return map;
    }



}
