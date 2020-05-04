package com.learn.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.security.dao.UmsAdminDao;
import com.learn.security.dao.UmsAdminRoleRelationDao;
import com.learn.security.entity.UmsAdmin;
import com.learn.security.entity.UmsPermission;
import com.learn.security.service.UmsAdminService;
import com.learn.security.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 10:57
 * @version： 1.0
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminRoleRelationDao, UmsPermission> implements UmsAdminService {

    private Logger LOGGER  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsAdminDao umsAdminDao;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        List<UmsAdmin> admins = umsAdminDao.selectList(wrapper);
        if (admins != null && admins.size() > 0) {
            return admins.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", umsAdminParam.getUsername());
        UmsAdmin admin = this.umsAdminDao.selectOne(queryWrapper);
        if (admin != null) {
            return null;
        }
        umsAdminParam.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));
        this.umsAdminDao.insert(umsAdminParam);
        return umsAdminParam;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = tokenUtil.generateDate(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登陆异常：{}",e.getMessage());
        }
        return token;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return this.baseMapper.getPermissionList(adminId);
    }
}
