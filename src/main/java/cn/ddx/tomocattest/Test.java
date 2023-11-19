package cn.ddx.tomocattest;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
            for (int i = 0; i < 1000; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                       HttpUtil.get("http://127.0.0.1:8080/get?num=" + finalI);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        //阻塞主线程
        Thread.yield();
    }
}
