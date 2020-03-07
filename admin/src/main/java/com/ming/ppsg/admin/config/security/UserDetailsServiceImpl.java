package com.ming.ppsg.admin.config.security;

import com.ming.ppsg.admin.entity.SysRole;
import com.ming.ppsg.admin.entity.SysUser;
import com.ming.ppsg.admin.entity.SysUserRole;
import com.ming.ppsg.admin.mapper.SysRoleMapper;
import com.ming.ppsg.admin.mapper.SysUserRoleMapper;
import com.ming.ppsg.admin.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 用户登录认证信息查询
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByName(username);
        if(user!=null && user.getId()!=null){
            List<SysUserRole> roleList = sysUserRoleMapper.findUserRoles(user.getId());
            if(!roleList.isEmpty()){
                SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleList.get(0).getRoleId());
                user.setRoleNames(sysRole.getName());
            }
        }
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(user.getName());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());

        JwtUserDetails jwtUserDetails = new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
        jwtUserDetails.setRoleName(user.getRoleNames());
        return jwtUserDetails;
    }
}