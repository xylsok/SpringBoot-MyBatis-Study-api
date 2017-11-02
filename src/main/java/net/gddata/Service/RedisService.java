package net.gddata.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzf on 17/10/27.
 */
public interface RedisService   {
    public void set(String key, Object value, Long x, TimeUnit timeUnit);

    public Object get(String key);
}
