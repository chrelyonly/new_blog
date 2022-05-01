package blog.chrelyonly.cn.controller;

import blog.chrelyonly.cn.entity.NavigationMenu;
import blog.chrelyonly.cn.service.INavigationMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 导航栏菜单
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Api(tags="导航栏菜单")
@RestController
@RequestMapping("/NavigationMenu/navigationMenu")
@Slf4j
@AllArgsConstructor
public class NavigationMenuController extends JeecgController<NavigationMenu, INavigationMenuService> {
	private final INavigationMenuService navigationMenuService;

	/**
	 * 分页列表查询
	 *
	 * @param navigationMenu
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "导航栏菜单-分页列表查询")
	@ApiOperation(value="导航栏菜单-分页列表查询", notes="导航栏菜单-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NavigationMenu>> queryPageList(NavigationMenu navigationMenu,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NavigationMenu> queryWrapper = QueryGenerator.initQueryWrapper(navigationMenu, req.getParameterMap());
		Page<NavigationMenu> page = new Page<NavigationMenu>(pageNo, pageSize);
		IPage<NavigationMenu> pageList = navigationMenuService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param navigationMenu
	 * @return
	 */
	@AutoLog(value = "导航栏菜单-添加")
	@ApiOperation(value="导航栏菜单-添加", notes="导航栏菜单-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NavigationMenu navigationMenu) {
		navigationMenuService.save(navigationMenu);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param navigationMenu
	 * @return
	 */
	@AutoLog(value = "导航栏菜单-编辑")
	@ApiOperation(value="导航栏菜单-编辑", notes="导航栏菜单-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NavigationMenu navigationMenu) {
		navigationMenuService.updateById(navigationMenu);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "导航栏菜单-通过id删除")
	@ApiOperation(value="导航栏菜单-通过id删除", notes="导航栏菜单-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		navigationMenuService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "导航栏菜单-批量删除")
	@ApiOperation(value="导航栏菜单-批量删除", notes="导航栏菜单-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.navigationMenuService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "导航栏菜单-通过id查询")
	@ApiOperation(value="导航栏菜单-通过id查询", notes="导航栏菜单-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NavigationMenu> queryById(@RequestParam(name="id",required=true) String id) {
		NavigationMenu navigationMenu = navigationMenuService.getById(id);
		if(navigationMenu==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(navigationMenu);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param navigationMenu
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NavigationMenu navigationMenu) {
        return super.exportXls(request, navigationMenu, NavigationMenu.class, "导航栏菜单");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NavigationMenu.class);
    }

}
