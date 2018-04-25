package com.ximua.concurrency.example.publish;

import com.ximua.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@NotThreadSafe
@Slf4j
public class UnSafePublish {
    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish publish = new UnSafePublish();
        System.out.println(Arrays.toString(publish.getStates()));

        publish.getStates()[0] = "d";
        System.out.println(Arrays.toString(publish.getStates()));
    }
}
