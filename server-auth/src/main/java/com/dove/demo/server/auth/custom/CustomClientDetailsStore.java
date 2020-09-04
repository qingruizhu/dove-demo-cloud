package com.dove.demo.server.auth.custom;

import com.dove.common.oauth2.server.component.ClientDetailsStore;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/15 10:28
 */
@Component
public class CustomClientDetailsStore implements ClientDetailsStore {

    @Override
    public List<? extends BaseClientDetails> clientDetails() {
        ArrayList<BaseClientDetails> baseClientDetails = new ArrayList<>();

        BaseClientDetails uac = new BaseClientDetails();
        uac.setClientId("uac-client");
        uac.setClientSecret("uac-secret-8888");
        uac.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "password", "refresh_token"));
        uac.setAccessTokenValiditySeconds(3600);
        uac.setRefreshTokenValiditySeconds(5400);
        uac.setScope(Arrays.asList("all"));
        baseClientDetails.add(uac);

        BaseClientDetails latestage = new BaseClientDetails();
        latestage.setClientId("a-client");
        latestage.setClientSecret("a-secret-8888");
        latestage.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "password", "refresh_token"));
        latestage.setAccessTokenValiditySeconds(3600);
        latestage.setRefreshTokenValiditySeconds(5400);
        latestage.setScope(Arrays.asList("all"));
        baseClientDetails.add(latestage);

        return baseClientDetails;
    }
}
