package com.frc.chooseoption.entity;

import com.frc.chooseoption.entity.Problems;
import com.frc.chooseoption.entity.ProblemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemsMapper {
    long countByExample(ProblemsExample example);

    int deleteByExample(ProblemsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Problems record);

    int insertSelective(Problems record);

    List<Problems> selectByExample(ProblemsExample example);

    Problems selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Problems record, @Param("example") ProblemsExample example);

    int updateByExample(@Param("record") Problems record, @Param("example") ProblemsExample example);

    int updateByPrimaryKeySelective(Problems record);

    int updateByPrimaryKey(Problems record);
}