package com.atcjw.order.service.impl;

import com.atcjw.model.vod.VideoVisitor;
import com.atcjw.vo.vod.VideoVisitorCountVo;
import com.atcjw.order.dao.VideoVisitorMapper;
import com.atcjw.order.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {
    @Autowired
    VideoVisitorMapper videoVisitorMapper;

    @Override
    public Map<String, Object> countCourse(Long courseId, String startDate, String endDate) {
        List<VideoVisitorCountVo> countVoList = videoVisitorMapper.countCourse(courseId, startDate, endDate);
        List<String> dateList = countVoList.stream().map(VideoVisitorCountVo::getJoinTime)
                .collect(Collectors.toList());
        List<Integer> countList = countVoList.stream().map(VideoVisitorCountVo::getUserCount)
                .collect(Collectors.toList());
        Map<String, Object> result = new HashMap<>();
        result.put("xData", dateList);
        result.put("yData", countList);
        return result;
    }
}
