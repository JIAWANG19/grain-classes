package com.atcjw.order.service;

import com.atcjw.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    List<Subject> getByParentId(int parentId);
}
