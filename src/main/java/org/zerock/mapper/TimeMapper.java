package org.zerock.mapper;


import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("SELECT mno FROM 회원 WHERE userid = 'aa787574' ")
    public String getTime();
}
