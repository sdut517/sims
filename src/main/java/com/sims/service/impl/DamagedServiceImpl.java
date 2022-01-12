package com.sims.service.impl;

import com.sims.dao.DamagedMapper;
import com.sims.dao.TypeMapper;
import com.sims.pojo.Damaged;
import com.sims.pojo.DamagedExample;
import com.sims.pojo.Type;
import com.sims.service.DamagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamagedServiceImpl implements DamagedService {

    @Autowired
    private DamagedMapper DamagedMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public long countByExample(DamagedExample example) {
        // TODO Auto-generated method stub
        return DamagedMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DamagedExample example) {
        // TODO Auto-generated method stub
        return DamagedMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return DamagedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Damaged record) {
        // TODO Auto-generated method stub
        return DamagedMapper.insert(record);
    }

    @Override
    public int insertSelective(Damaged record) {
        // TODO Auto-generated method stub
        return DamagedMapper.insertSelective(record);
    }

    @Override
    public List<Damaged> selectByExample(DamagedExample example) {
        // TODO Auto-generated method stub
        List<Damaged> Damageds = DamagedMapper.selectByExample(example);
        for (Damaged Damaged : Damageds) {
            Damaged.setTypeName(typeMapper.selectByPrimaryKey(Damaged.getTypeId())
                    .getType());
        }
        return Damageds;
    }

    @Override
    public Damaged selectByPrimaryKey(String id) {
        Damaged Damaged = DamagedMapper.selectByPrimaryKey(id);
        Type type = typeMapper.selectByPrimaryKey(Damaged.getTypeId());
        Damaged.setTypeName(type.getType());
        // TODO Auto-generated method stub
        return Damaged;
    }

    @Override
    public int updateByExampleSelective(Damaged record, DamagedExample example) {
        // TODO Auto-generated method stub
        return DamagedMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Damaged record, DamagedExample example) {
        // TODO Auto-generated method stub
        return DamagedMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Damaged record) {
        // TODO Auto-generated method stub
        return DamagedMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Damaged record) {
        // TODO Auto-generated method stub
        return DamagedMapper.updateByPrimaryKey(record);
    }

}
