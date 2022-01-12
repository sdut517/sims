package com.sims.service;

import com.sims.pojo.Damaged;
import com.sims.pojo.DamagedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DamagedService {
	long countByExample(DamagedExample example);

	int deleteByExample(DamagedExample example);

	int deleteByPrimaryKey(String id);

	int insert(Damaged record);

	int insertSelective(Damaged record);

	List<Damaged> selectByExample(DamagedExample example);

	Damaged selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Damaged record,
			@Param("example") DamagedExample example);

	int updateByExample(@Param("record") Damaged record,
			@Param("example") DamagedExample example);

	int updateByPrimaryKeySelective(Damaged record);

	int updateByPrimaryKey(Damaged record);
}
