package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.Teacher;
import com.atcjw.vod.dao.TeacherMapper;
import com.atcjw.vod.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
