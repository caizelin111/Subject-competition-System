package com.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启Spring方法级安全,会拦截@prePostEnabled注解的配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private CustomUserService customUserService;

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/index").permitAll()
//                .antMatchers("/user/").hasAnyRole("user")
//                .antMatchers("/helloAdmin").hasAnyRole("admin");


        //没有权限会默认会跳到登录页面,需要开启
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");//和表单中的action方法要一样
        //注销，开启注销给你
        //防止网站攻击：通常登录登出是通过get请求的，get不安全，明文传输 （换成post可以）
        http.csrf().disable().headers().frameOptions().sameOrigin();//关闭防止跨站请求攻击的功能，登出失败的原因
        //.headers().frameOptions().sameOrigin();是用来配置Spring Security允许iframe frame加载同源的资源
        http.logout().logoutSuccessUrl("/toLogin");//后面加路径可以指定注销成功后退到其他路径界面

        //开启记住我功能 cookie，默认保存两周， 自定义接收前端参数
        http.rememberMe().rememberMeParameter("remember");
    }

    //认证 你，springboot 2.1.X可以直接使用~
    //密码编码：PasswoEncoder
    //在Springsecurity 5.0+新增了很多加密方法
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置内存对象
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder()).withUser("czl")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                .roles("ADMIN")
//                .and()
//               .passwordEncoder(new BCryptPasswordEncoder()).withUser("stt")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("USER");
        auth.userDetailsService(customUserService);
    }

    //加密
    @Bean //注入编码方法，成为spring托管的一个bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

/*
 spring Security下，X-Frame-Options默认为DENY,非spring Security环境下，X-Frame-Options的默认大多也是DENY，这种情况下，浏览器拒绝当前页面加载任何Frame页面，设置含义如下：

            DENY：浏览器拒绝当前页面加载任何Frame页面
            SAMEORIGIN：frame页面的地址只能为同源域名下的页面
            ALLOW-FROM：origin为允许frame加载的页面地址。

*/

