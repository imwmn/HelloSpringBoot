package com.wmn.HelloSpringBoot.Repository;

import com.wmn.HelloSpringBoot.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link org.springframework.stereotype.Repository}
 */

@Repository
public class UserRepository {
    private ConcurrentMap<Integer,User > map = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator =
            new AtomicInteger();

    /**
     * 保存用户对象
     * @param user
     * @return  如果保存成功，返回<code>true</code>
     *                          否则<code>false</code>
     */

    public boolean save(User user){
            int id = idGenerator.incrementAndGet();
            user.setId(id);
            return   map.put(id,user)==null;
    }
public Collection<User> findAll(){
       return map.values();
}
}
