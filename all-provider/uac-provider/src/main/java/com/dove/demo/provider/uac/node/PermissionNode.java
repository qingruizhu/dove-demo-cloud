package com.dove.demo.provider.uac.node;

import com.dove.common.util.data.TreeNodeUtil;
import com.dove.demo.bgd.uac.model.Permission;

import java.util.List;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/7/27 01:06
 */
public class PermissionNode extends Permission implements TreeNodeUtil.Node<PermissionNode> {

    private List<PermissionNode> children;

    @Override
    public Long getNodeId() {
        return getId();
    }

    @Override
    public Long getNodeParentId() {
        return getPid();
    }

    @Override
    public List<PermissionNode> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<PermissionNode> children) {
        this.children = children;
    }
}
