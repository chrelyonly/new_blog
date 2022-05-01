package blog.chrelyonly.cn.service.impl;

import blog.chrelyonly.cn.entity.BlogDivSidebar;
import blog.chrelyonly.cn.mapper.BlogDivSidebarMapper;
import blog.chrelyonly.cn.service.IBlogDivSidebarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description: 自定义侧边栏
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Service
@Primary
public class BlogDivSidebarServiceImpl extends ServiceImpl<BlogDivSidebarMapper, BlogDivSidebar> implements IBlogDivSidebarService {

}
