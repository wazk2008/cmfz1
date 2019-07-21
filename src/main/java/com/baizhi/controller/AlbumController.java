package com.baizhi.controller;

import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("selectAllAlbum")
    public Map<String,Object> selectAllAlbum(Integer page,Integer rows,String albumId){
        Map<String, Object> map = albumService.selectAllAlbum(page, rows);
        return map;
    }




}
