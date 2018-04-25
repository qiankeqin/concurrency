package com.ximua.concurrency.example.threadlocal;

public class RequestHolder {
    private final static ThreadLocal<Long> requestHoulder = new ThreadLocal<>();
    //在接口被调用之前操作
    public static void add(Long id){
        requestHoulder.set(id);
    }

    //根据线程Id获取
    public static Long getId(){
        return requestHoulder.get();
    }

    //在接口调用完成后。。。结束了
    //防止内存泄漏
    public static void remove(){
        requestHoulder.remove();
    }
}
