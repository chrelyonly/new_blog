package blog.chrelyonly.cn.service.impl;

import blog.chrelyonly.cn.entity.BlogArticle;
import blog.chrelyonly.cn.mapper.BlogArticleMapper;
import blog.chrelyonly.cn.service.IBlogArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description: 博客文章
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Service
@Primary
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {

}
