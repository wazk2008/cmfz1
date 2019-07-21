package com.baizhi.service;

import java.util.Map;

public interface ChapterService {

    Map<String,Object> selectChaptersByAlbumId(Integer page, Integer rows,String albumId);

}
