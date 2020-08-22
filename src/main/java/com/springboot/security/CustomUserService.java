package com.springboot.security;

import com.springboot.model.AyUser;
import com.springboot.model.AyUserRoleRel;
import com.springboot.service.AyRoleService;
import com.springboot.service.AyUserRoleRelService;
import com.springboot.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
    @Resource
    private AyUserService ayUserService;
    @Resource
    private AyRoleService ayRoleService;
    @Resource
    private AyUserRoleRelService ayUserRoleRelService;
    @Autowired
    private PasswordEncoder passwordEncoder;//导入在webSecurityConfig里面定义的编码bean

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AyUser ayUser = ayUserService.findByName(name);
        if (ayUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
//        通过用户的userid找到权限表(userid,roleid),进而找到role表。
        List<AyUserRoleRel> ayRoleList = ayUserRoleRelService.findByUserId(ayUser.getId());//找到用户角色关联表的相关组
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();//存放角色集合
        if (ayRoleList != null && ayRoleList.size() > 0) {
            for (AyUserRoleRel rel : ayRoleList) {
                String rolename = ayRoleService.find(rel.getRoleId()).getName();//在角色表中根据role_id找到用户的角色
                authorityList.add(new SimpleGrantedAuthority("ROLE_" + rolename));//把每一个角色添加进去
            }
        }
        return new User(ayUser.getName(), passwordEncoder.encode(ayUser.getPassword()), authorityList);//这里的password同样需要加密
    }
}

