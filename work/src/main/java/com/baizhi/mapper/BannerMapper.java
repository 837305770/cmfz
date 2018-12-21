package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    //查总行数
    public Integer selectTotalCount();

    //查当前页的行数
    public List<Banner> selectByPage(@Param("curPage") int curPage, @Param("pageSize") int pageSize);

}
