package com.ximua.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.ximua.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
@Slf4j
public class ImmutableExample2 {
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //执行报，不允许修改
        map.put(1,3);
        log.info("{}",map.get(1));
    }
}
