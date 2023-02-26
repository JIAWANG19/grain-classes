package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.Course;
import com.atcjw.model.vod.CourseDescription;
import com.atcjw.model.vod.Subject;
import com.atcjw.model.vod.Teacher;
import com.atcjw.vo.vod.CourseFormVo;
import com.atcjw.vo.vod.CourseQueryVo;
import com.atcjw.vod.dao.CourseMapper;
import com.atcjw.vod.service.CourseDescriptionService;
import com.atcjw.vod.service.CourseService;
import com.atcjw.vod.service.SubjectService;
import com.atcjw.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseDescriptionService courseDescriptionService;

    @Override
    public Page<Course> pageQuery(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        String title = courseQueryVo.getTitle();
        Long subjectId = courseQueryVo.getSubjectId();
        Long subjectParentId = courseQueryVo.getSubjectParentId();
        Long teacherId = courseQueryVo.getTeacherId();
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(title)) {
            wrapper.like("title", title);
        }
        if (subjectId != null) {
            wrapper.eq("subject_id", subjectId);
        }
        if (subjectParentId != null) {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (teacherId != null) {
            wrapper.eq("teacher_id", teacherId);
        }
        Page<Course> page = courseMapper.selectPage(pageParam, wrapper);
        page.getRecords().forEach(this::addInfo);
        return page;
    }

    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        // 添加课程的基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        courseMapper.insert(course);
        // 添加课程的描述信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        courseDescription.setId(course.getId());
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.save(courseDescription);
        return course.getId();
    }

    @Override
    public CourseFormVo getInfoById(long id) {
        Course course = courseMapper.selectById(id);
        if (course == null) {
            return null;
        }
        CourseDescription courseDescription = courseDescriptionService.getById(id);
        CourseFormVo courseFormVo = new CourseFormVo();

        BeanUtils.copyProperties(course, courseFormVo);
        if (courseDescription != null) {
            courseFormVo.setDescription(courseDescription.getDescription());
        }
        return courseFormVo;
    }

    @Override
    public boolean updateCourseInfo(CourseFormVo courseFormVo) {
        // todo
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo,course);
        courseMapper.updateById(course);
        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        courseDescriptionService.updateById(description);
        return true;
    }

    private void addInfo(Course course) {
        Teacher teacher = teacherService.getById(course.getTeacherId());
        if (teacher!= null) {
            course.getParam().put("teacherName", teacher.getName());
        }
        Subject subjectParent = subjectService.getById(course.getSubjectParentId());
        if (subjectParent != null) {
            course.getParam().put("subjectParentTitle", subjectParent.getTitle());
        }
        Subject subject = subjectService.getById(course.getSubjectId());
        if (subject != null) {
            course.getParam().put("subjectTitle", subject.getTitle());
        }
    }
}
