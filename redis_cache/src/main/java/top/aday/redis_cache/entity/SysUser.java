package top.aday.redis_cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 州牧
 * @description
 * @since 2022-07-06 09:55
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SysUser implements Serializable {
    private Long id;
    private String name;
}
