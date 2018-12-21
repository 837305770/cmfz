package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @RequestMapping("/queryAll")
    public List<Album> queryAll(Album album) {
        List<Album> albums = albumService.queryAll();
        return albums;
    }

    //查询单个专辑详情
    @RequestMapping("/queryById")
    public String queryById(Integer id) {
        albumService.queryById(id);
        return "redirect:/jsp/album1.jsp";
    }

    //添加专辑
    @RequestMapping("/insert")
    public void insert(HttpSession session, MultipartFile file, Album album) throws IOException {
        albumService.insert(session, file, album);
    }
}
