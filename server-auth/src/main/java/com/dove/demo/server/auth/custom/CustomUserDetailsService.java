package com.dove.demo.server.auth.custom;//package com.dove.common.oauth2.component;

import com.common.dove.oauth2.base.principal.OauthUser;
import com.dove.demo.provider.api.uac.IUserServiceApi;
import com.dove.demo.provider.api.uac.dto.UserDto;
import com.dove.demo.provider.api.uac.request.RequestUser;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/12 09:47
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    //用户
    @Reference
    IUserServiceApi userServiceApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.user
        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(username);
        requestUser.setStatus(1);
        UserDto userDto = userServiceApi.select(requestUser);
        if (null == userDto) {
            throw new UsernameNotFoundException("the user:" + username + " is not found");
        }
        OauthUser oauthUser = new OauthUser(userDto.getId(), null, userDto.getPhone(), userDto.getUsername(), userDto.getPassword(), null);
        return oauthUser;
    }


}
