package com.dove.demo.server.auth.custom;//package com.dove.common.oauth2.component;

import com.dove.demo.provider.api.uac.IUserServiceApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.user
//        RequestUser requestUser = new RequestUser();
//        requestUser.setUsername(username);
//        requestUser.setStatus(1);
//        UserDto userDto = userServiceApi.select(requestUser);
//        if (null == userDto) {
//            throw new UsernameNotFoundException("the user:" + username + " is not found");
//        }
//        OauthUser oauthUser = new OauthUser(userDto.getId(), null, userDto.getPhone(), userDto.getUsername(), userDto.getPassword(), null);
//        OauthUser oauthUser = new OauthUser(1L, null, null, "guest", "c88e6adf7bb18a50a56c493d656d4dc03da86f9d9a0a48a1b581f8fa75f14a06", null);
        String role = "ROLE_ADMIN";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return new User(username, passwordEncoder.encode("123456"), authorities);
    }


}
