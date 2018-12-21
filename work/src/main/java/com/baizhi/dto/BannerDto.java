package com.baizhi.dto;

import com.baizhi.entity.Banner;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BannerDto implements Serializable {
    private Integer total;//总行数
    private List<Banner> rows;//每页显示的行数
}
