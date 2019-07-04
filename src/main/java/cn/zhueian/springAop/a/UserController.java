package cn.zhueian.springAop.a;

import groovy.util.logging.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: qiucy
 * @Date: 2019-05-14 15:27
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping("/login/{id}")
    public String login(){
        //查询时间
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "name:zhueian!!";
    }
}
