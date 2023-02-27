package com.atcjw.order.service.impl;

import com.atcjw.model.vod.Teacher;
import com.atcjw.order.dao.TeacherMapper;
import com.atcjw.order.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
