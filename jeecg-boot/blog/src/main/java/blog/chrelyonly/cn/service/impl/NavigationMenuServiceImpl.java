package blog.chrelyonly.cn.service.impl;

import blog.chrelyonly.cn.entity.NavigationMenu;
import blog.chrelyonly.cn.mapper.NavigationMenuMapper;
import blog.chrelyonly.cn.service.INavigationMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description: 导航栏菜单
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Service
@Primary
public class NavigationMenuServiceImpl extends ServiceImpl<NavigationMenuMapper, NavigationMenu> implements INavigationMenuService {

}
