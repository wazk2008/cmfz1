package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public Map<String, Object> selectAllAlbum(Integer page, Integer rows) {
        Album album = new Album();
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Album> albums = albumDao.selectByRowBounds(album, rowBounds);
        int count = albumDao.selectCount(album);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page",page);
        map.put("total",count%rows==0?count/rows:count/rows+1);
        map.put("rows",albums);
        map.put("records",count);
        return map;
    }
}
