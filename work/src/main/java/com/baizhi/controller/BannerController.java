package com.baizhi.controller;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    //分页查普通用户
    @RequestMapping("/queryByPage")
    public BannerDto queryByPage(int page, int rows, Banner banner) {
        return bannerService.queryByPage(page, rows);
    }

    //添加信息
    @RequestMapping("/insert")
    public void insert(HttpSession session, MultipartFile file1, Banner banner) throws IOException {
        System.out.println("++++++++++" + file1);
        bannerService.insert(session, file1, banner);

    }

    // 删除信息
    @RequestMapping("/delete")
    public void delete(Integer id) {
        bannerService.delete(id);
    }

}
