package com.frc.chooseoption.entity;

import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.entity.OptionGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionGroupMapper {
    long countByExample(OptionGroupExample example);

    int deleteByExample(OptionGroupExample example);

    int deleteByPrimaryKey(Integer groupid);

    int insert(OptionGroup record);

    int insertSelective(OptionGroup record);

    List<OptionGroup> selectByExample(OptionGroupExample example);

    OptionGroup selectByPrimaryKey(Integer groupid);

    int updateByExampleSelective(@Param("record") OptionGroup record, @Param("example") OptionGroupExample example);

    int updateByExample(@Param("record") OptionGroup record, @Param("example") OptionGroupExample example);

    int updateByPrimaryKeySelective(OptionGroup record);

    int updateByPrimaryKey(OptionGroup record);
}