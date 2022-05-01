package blog.chrelyonly.cn.service.impl;

import blog.chrelyonly.cn.entity.BlogFoot;
import blog.chrelyonly.cn.mapper.BlogFootMapper;
import blog.chrelyonly.cn.service.IBlogFootService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 底部备案等作者等信息
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Service
@Primary
public class BlogFootServiceImpl extends ServiceImpl<BlogFootMapper, BlogFoot> implements IBlogFootService {

}
