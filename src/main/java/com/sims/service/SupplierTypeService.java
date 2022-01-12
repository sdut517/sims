package com.sims.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sims.pojo.SupplierType;
import com.sims.pojo.SupplierTypeExample;

public interface SupplierTypeService {
	long countByExample(SupplierTypeExample example);

	int deleteByExample(SupplierTypeExample example);

	int deleteByPrimaryKey(String id);

	int insert(SupplierType record);

	int insertSelective(SupplierType record);

	List<SupplierType> selectByExample(SupplierTypeExample example);

	SupplierType selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") SupplierType record,
			@Param("example") SupplierTypeExample example);

	int updateByExample(@Param("record") SupplierType record,
			@Param("example") SupplierTypeExample example);

	int updateByPrimaryKeySelective(SupplierType record);

	int updateByPrimaryKey(SupplierType record);
}
