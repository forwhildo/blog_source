package top.aday.redis_cache.mapper;

import top.aday.redis_cache.entity.SysUser;

import java.util.List;

public interface UserMapper {
    List<SysUser> findAllById(Long id);

    void insert(SysUser sysUser);
}
