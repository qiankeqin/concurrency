package com.ximua.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.ximua.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList list = ImmutableList.of(1,2,3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    private final static ImmutableMap<Integer,Integer> map =
            ImmutableMap.of(1,2,3,4);//1:2,3:4键值对形式
    //map创建对第二种方法
    private final static ImmutableMap<Integer,Integer> map2 =
            ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();
    public static void main(String[] args) {
        map.put(1,4);
    }
}
