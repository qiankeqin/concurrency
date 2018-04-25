package com.ximua.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.ximua.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    //直接这么写，容易造成线程安全问题
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //编译不通过
//        a = 2;
//        b = "3";
        map.put(1,8);
        //编译不通，不允许指向新的对象，但是可以修改map里面的值
//        map = Maps.newHashMap();
        log.info("{}",map.get(1));
    }

    //final可以修饰型参
    private void test(final int a){
        //编译报错
//        a = 1;
    }

}
