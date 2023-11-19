package cn.ddx.tomocattest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@Slf4j
public class TomocattestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomocattestApplication.class, args);
    }

    @GetMapping("/get")
    public String test(int num) {
        log.info("{} 接受到请求:num={}", Thread.currentThread().getName(), num);
        try {
            TimeUnit.MINUTES.sleep(1);
            System.out.println("---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "接受到请求:num=" + num;
    }

}
