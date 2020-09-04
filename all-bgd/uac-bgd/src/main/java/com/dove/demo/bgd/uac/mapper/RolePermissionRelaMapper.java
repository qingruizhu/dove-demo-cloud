package com.dove.demo.bgd.uac.mapper;

import com.dove.demo.bgd.uac.model.RolePermissionRela;
import com.dove.demo.bgd.uac.model.RolePermissionRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionRelaMapper {
    long countByExample(RolePermissionRelaExample example);

    int deleteByExample(RolePermissionRelaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionRela record);

    int insertSelective(RolePermissionRela record);

    List<RolePermissionRela> selectByExample(RolePermissionRelaExample example);

    RolePermissionRela selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RolePermissionRela record, @Param("example") RolePermissionRelaExample example);

    int updateByExample(@Param("record") RolePermissionRela record, @Param("example") RolePermissionRelaExample example);

    int updateByPrimaryKeySelective(RolePermissionRela record);

    int updateByPrimaryKey(RolePermissionRela record);
}