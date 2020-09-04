package com.dove.demo.bgd.uac.mapper;

import com.dove.demo.bgd.uac.model.UserRoleRela;
import com.dove.demo.bgd.uac.model.UserRoleRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelaMapper {
    long countByExample(UserRoleRelaExample example);

    int deleteByExample(UserRoleRelaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRoleRela record);

    int insertSelective(UserRoleRela record);

    List<UserRoleRela> selectByExample(UserRoleRelaExample example);

    UserRoleRela selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    int updateByExample(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    int updateByPrimaryKeySelective(UserRoleRela record);

    int updateByPrimaryKey(UserRoleRela record);
}