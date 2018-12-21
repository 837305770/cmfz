package com.baizhi.service;

import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface AlbumService {
    public List<Album> queryAll();

    //查询单个专辑详情
    public Album queryById(Integer id);

    //添加专辑
    public void insert(HttpSession session, MultipartFile file, Album album) throws IOException;
}
