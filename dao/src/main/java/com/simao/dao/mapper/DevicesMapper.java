package com.simao.dao.mapper;

import com.simao.dao.model.Devices;
import com.simao.dao.model.DevicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicesMapper {
    long countByExample(DevicesExample example);

    int deleteByExample(DevicesExample example);

    int deleteByPrimaryKey(byte[] uuid);

    int insert(Devices record);

    int insertSelective(Devices record);

    List<Devices> selectByExample(DevicesExample example);

    Devices selectByPrimaryKey(byte[] uuid);

    int updateByExampleSelective(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByExample(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);
}