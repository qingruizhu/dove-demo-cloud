package com.dove.demo.bgd.uac.service.abs;

import com.dove.demo.bgd.uac.mapper.UserMapper;
import com.dove.demo.bgd.uac.model.User;
import com.dove.demo.bgd.uac.model.UserExample;
import com.dove.demo.bgd.uac.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

public abstract class AbsUserService<Q> implements IUserService<Q> {

    @Resource
    private UserMapper mapper;

    @Override
    public List<User> list(User tab) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (null != tab.getId()) {
            criteria.andIdEqualTo(tab.getId());
        }
        if (StringUtils.isNotEmpty(tab.getPhone())) {
            criteria.andPhoneEqualTo(tab.getPhone());
        }
        if (StringUtils.isNotEmpty(tab.getUsername())) {
//            criteria.andUserNameLike("%" + tab.getUserName() + "%");
            criteria.andUsernameEqualTo(tab.getUsername());
        }
//        example.setOrderByClause("sort asc");
        return mapper.selectByExample(example);
    }

    @Override
    public User select(Long primaryKey) {
        return mapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public User select(User tab) {
        if (null != tab.getId()) {
            return mapper.selectByPrimaryKey(tab.getId());
        }
        List<User> Users = list(tab);
        if (CollectionUtils.isEmpty(Users)) {
            return null;
        }
        return Users.get(0);
    }

    @Override
    public User selectByKey(String key, Object value) {
        if (StringUtils.isEmpty(key) || null == value) {
            return null;
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        switch (key) {
            case "username":
                criteria.andUsernameEqualTo((String) value);
                break;
            case "phone":
                criteria.andPhoneEqualTo((String) value);
                break;
            default:
                return null;
        }
        List<User> userInfos = mapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(userInfos)) {
            return userInfos.get(0);
        }
        return null;
    }

    @Override
    public int insert(User User) {
        return mapper.insertSelective(User);
    }

    @Override
    public int update(User tab) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (null != tab.getId()) {
            criteria.andIdEqualTo(tab.getId());
        }
        if (!criteria.isValid()) {
            return 0;
        }
        return mapper.updateByExampleSelective(tab, example);
    }

    @Override
    public int delete(Long primaryKey) {
        return mapper.deleteByPrimaryKey(primaryKey);
    }


    @Override
    public User copyQ(Q q) {
        User User = new User();
        BeanUtils.copyProperties(q, User);
        return User;
    }

    @Override
    public List<User> listQ(Q q) {
        return this.list(copyQ(q));
    }

    @Override
    public User selectQ(Q q) {
        return this.select(copyQ(q));
    }

    @Override
    public int insertQ(Q q) {
        return this.insert(copyQ(q));
    }

    @Override
    public int updateQ(Q q) {
        return this.update(copyQ(q));
    }
}
