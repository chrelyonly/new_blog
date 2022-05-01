package blog.chrelyonly.cn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chrelyonly
 */
@Component
@Slf4j
public class DivUtil {
    @PostConstruct
    public void initialize(){
        log.info("博客模块初始化....");
    }
}
