package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public void login(String name, String password) {
        Admin admin = adminMapper.login(name);
        if (admin == null)
            throw new RuntimeException("管理员不存在");
        if (!admin.getPassword().equals(password))
            throw new RuntimeException("密码重复");

    }
}
