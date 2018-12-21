package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public BannerDto queryByPage(int curPage, int pageSize) {
        BannerDto dto = new BannerDto();
        //设置总行数
        dto.setTotal(bannerMapper.selectTotalCount());
        //设置当前页的行数
        dto.setRows(bannerMapper.selectByPage(curPage, pageSize));
        return dto;
    }

    @Override
    public void insert(HttpSession session, MultipartFile file1, Banner banner) throws IOException {

        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/upload");
        //目标文件
        Long time = new Date().getTime();
        File file = new File(realPath + "/" + time + "-" + file1.getOriginalFilename());
        //上传
        file1.transferTo(file);
        Banner banner1 = new Banner(null, banner.getTitle(), "/upload" + "/" + time + "-" + file1.getOriginalFilename(), banner.getStatus(), banner.getPubDate(), banner.getDescription());
        bannerMapper.insert(banner1);

    }

    @Override
    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Banner queryById(Integer id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return banner;
    }
}
