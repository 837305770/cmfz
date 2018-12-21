package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    ChapterMapper chapterMapper;

    @Override
    public List<Album> queryAll() {
        List<Album> albums = albumMapper.queryAll();
        return albums
                ;

    }

    //查询单个专辑详情
    @Override
    public Album queryById(Integer id) {
        Album album = albumMapper.selectByPrimaryKey(id);
        return album;
    }

    @Override
    public void insert(HttpSession session, MultipartFile file, Album album) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/upload");
        //目标文件
        long time = new Date().getTime();
        File file1 = new File(realPath + "/" + time + "-" + file.getOriginalFilename());
        //上传文件
        file.transferTo(file1);
        Album album1 = new Album(null, album.getTitle(), album.getCount(), "/upload" + "/" + time + "-" + file.getOriginalFilename(), album.getAuthor(), album.getBroadcast(), album.getBrief(), album.getPubDate(), album.getChildren());
        albumMapper.insert(album1);
    }
}
