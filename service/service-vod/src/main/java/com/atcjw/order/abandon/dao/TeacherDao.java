package com.atcjw.order.abandon.dao;

import com.atcjw.model.vod.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface TeacherDao {
    String TABLE_NAME = "teacher";
    String ALL_COL = "id, `name`, intro, career, level, avatar, sort, join_date as joinDate, create_time, update_time";
    String AND_NOT_DELETE = " and is_deleted = 0";
    String WITH_NOT_DELETE = " where is_deleted = 0";

    @Select("select " + ALL_COL + " from " + TABLE_NAME + WITH_NOT_DELETE)
    List<Teacher> queryAllTeacher();

    @Update("update " + TABLE_NAME + " set name = #{name} where id = #{id}" + AND_NOT_DELETE)
    int updateNameById(@Param("name") String name,
                       @Param("id") long id);

    @Delete("update " + TABLE_NAME + " set is_deleted = 1 where id = #{id}")
    int deleteTeacher(@Param("id") long id);

    @Select("<script>" +
            " select " + ALL_COL + " from " + TABLE_NAME +
            " where 1=1" +
            " <if test = 'name != null'> and `name` like '%${name}%' </if>" +
            " <if test = 'level != null'> and level = #{level}</if>" + AND_NOT_DELETE +
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

    @Select("select " + ALL_COL + " from " + TABLE_NAME + " where id = #{id}" + AND_NOT_DELETE)
    Teacher queryById(@Param("id") long id);

    @Update("update " + TABLE_NAME + " set" +
            " name = #{teacher.name}," +
            " intro = #{teacher.name}," +
            " career = #{teacher.career}," +
            " avatar = #{teacher.avatar}," +
            " level = #{teacher.level}," +
            " sort = #{teacher.sort}" +
            " where id = #{id}" + AND_NOT_DELETE)
    int updateById(@Param("id") long id,
                   @Param("teacher") Teacher teacher);

    @Delete("<script>" +
            "update " + TABLE_NAME + " set is_deleted = 1 where id in (" +
            " <foreach collection = 'ids' separator=',' item='id'>" +
            " #{id}" +
            " </foreach>)" +
            " </script>")
    int deleteTeacherList(@Param("ids") List<Long> ids);
}
