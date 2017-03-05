package com.frc.chooseoption.entity;

import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.OptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionMapper {
    long countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Integer optionid);

    int insert(Option record);

    int insertSelective(Option record);
    
    int batchInsert(List<Option> list);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Integer optionid);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
    
    int batchUpdate(List<Option> list);
}