package com.sims.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sims.pojo.Stuff;
import com.sims.pojo.StuffExample;

public interface StuffService {
	long countByExample(StuffExample example);

	int deleteByExample(StuffExample example);

	int deleteByPrimaryKey(String id);

	int insert(Stuff record);

	int insertSelective(Stuff record);

	List<Stuff> selectByExample(StuffExample example);

	Stuff selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Stuff record,
			@Param("example") StuffExample example);

	int updateByExample(@Param("record") Stuff record,
			@Param("example") StuffExample example);

	int updateByPrimaryKeySelective(Stuff record);

	int updateByPrimaryKey(Stuff record);
}
