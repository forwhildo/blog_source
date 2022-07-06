package top.aday.redis_cache;

import org.apache.ibatis.cache.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import top.aday.redis_cache.entity.SysUser;
import top.aday.redis_cache.mapper.UserMapper;
import javax.annotation.Resource;

@SpringBootTest
class RedisCacheApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    UserMapper userMapper;

    @Test
//    @Transactional(rollbackFor = Throwable.class)
    public void test(){
        userMapper.findAllById(1L);
        System.out.println("===================================");
//        userMapper.insert(new SysUser(3L,"zhou"));
        userMapper.findAllById(1L);

    }



}
