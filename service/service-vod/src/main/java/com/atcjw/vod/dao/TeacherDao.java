package com.atcjw.vod.dao;

import com.atcjw.model.vod.Teacher;
import com.baomidou.mybatisplus.annotation.TableField;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherDao {
    String TABLE_NAME = "teacher";
    String ALL_COL = "id, name, intro, career, level, avatar, sort, join_date, create_time, update_time, is_deleted";

    @Select("select " + ALL_COL + " from " + TABLE_NAME)
    List<Teacher> queryAllTeacher();

//    @Insert("insert " + TABLE_NAME)

    @Update("update " + TABLE_NAME + " set name = #{name} where id = #{id}")
    int updateNameById(@Param("name") String name,
                       @Param("id") long id);

    @Delete("delete from " + TABLE_NAME + " where id = #{id}")
    int deleteTeacher(@Param("id") long id);
}
