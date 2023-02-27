package com.atcjw.order.service.impl;

import com.atcjw.model.vod.Subject;
import com.atcjw.order.dao.SubjectMapper;
import com.atcjw.order.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public List<Subject> getByParentId(int parentId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        List<Subject> subjects = subjectMapper.selectList(wrapper);
        subjects.forEach(e -> {
            if (hasChildren(e.getId())) {
                e.setHasChildren(true);
            }
        });
        return subjects;
    }

    private boolean hasChildren(long subjectId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", subjectId);
        Long count = subjectMapper.selectCount(wrapper);
        return count > 0;
    }
}
