package com.atcjw.vod.dao;

import com.atcjw.model.vod.Teacher;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherDao {
    String TABLE_NAME = "teacher";
    String ALL_COL = "id, `name`, intro, career, level, avatar, sort, join_date, create_time, update_time, is_deleted";

    @Select("select " + ALL_COL + " from " + TABLE_NAME)
    List<Teacher> queryAllTeacher();

//    @Insert("insert " + TABLE_NAME)

    @Update("update " + TABLE_NAME + " set name = #{name} where id = #{id}")
    int updateNameById(@Param("name") String name,
                       @Param("id") long id);

    @Delete("delete from " + TABLE_NAME + " where id = #{id}")
    int deleteTeacher(@Param("id") long id);

    @Select("<script>" +
            " select " + ALL_COL + " from " + TABLE_NAME +
            " where 1=1" +
            " <if test = 'name != null'> and `name` like '%${name}%' </if>" +
            " <if test = 'level != null'> and level = #{level}</if>" +
            " </script>")
    List<Teacher> queryWithVo(@Param("name") String name, @Param("level") Integer level);

    @Insert("insert into " + TABLE_NAME + " set" +
            " name = #{teacher.name}," +
            " intro = #{teacher.name}," +
            " career = #{teacher.career}," +
            " level = #{teacher.level}," +
            " avatar = #{teacher.avatar}," +
            " sort = #{teacher.sort}")
    int insertTeacher(@Param("teacher") Teacher teacher);

    @Select("select " + ALL_COL + " from " + TABLE_NAME + " where id = #{id}")
    Teacher queryById(@Param("id") long id);

    @Update("update " + TABLE_NAME + " set" +
            " name = #{teacher.name}," +
            " intro = #{teacher.name}," +
            " career = #{teacher.career}," +
            " avatar = #{teacher.avatar}," +
            " level = #{teacher.level}," +
            " sort = #{teacher.sort}" +
            " where id = #{id}")
    int updateById(@Param("id") long id,
                   @Param("teacher") Teacher teacher);

    @Delete("<script>" +
            "delete from " + TABLE_NAME + " where id in (" +
            " <foreach collection = 'ids' separator=',' item='id'>" +
            " #{id}" +
            " </foreach>)" +
            " </script>")
    int deleteTeacherList(@Param("ids") List<Long> ids);
}
