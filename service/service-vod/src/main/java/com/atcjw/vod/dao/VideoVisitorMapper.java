package com.atcjw.vod.dao;

import com.atcjw.model.vod.VideoVisitor;
import com.atcjw.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    List<VideoVisitorCountVo> countCourse(@Param("courseId") Long courseId,
                                          @Param("startDate") String startDate,
                                          @Param("endDate") String endDate);
}
