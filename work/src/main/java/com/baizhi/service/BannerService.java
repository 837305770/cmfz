package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface BannerService {
    //分页查普通用户
    public BannerDto queryByPage(int curPage, int pageSize);

    //添加信息
    public void insert(HttpSession session, MultipartFile imgPath, Banner banner) throws IOException;

    //修改信息
    public void update(Banner banner);

    //删除信息
    public void delete(Integer id);

    //查询单个信息
    public Banner queryById(Integer id);
}
