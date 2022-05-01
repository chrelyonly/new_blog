package blog.chrelyonly.cn.controller;

import blog.chrelyonly.cn.entity.BlogDivSidebar;
import blog.chrelyonly.cn.service.IBlogDivSidebarService;
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
 * @Description: 自定义侧边栏
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Api(tags="自定义侧边栏")
@RestController
@RequestMapping("/blog/blogDivSidebar")
@Slf4j
@AllArgsConstructor
public class BlogDivSidebarController extends JeecgController<BlogDivSidebar, IBlogDivSidebarService> {
	private final IBlogDivSidebarService blogDivSidebarService;

	/**
	 * 分页列表查询
	 *
	 * @param blogDivSidebar
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "自定义侧边栏-分页列表查询")
	@ApiOperation(value="自定义侧边栏-分页列表查询", notes="自定义侧边栏-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BlogDivSidebar>> queryPageList(BlogDivSidebar blogDivSidebar,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BlogDivSidebar> queryWrapper = QueryGenerator.initQueryWrapper(blogDivSidebar, req.getParameterMap());
		Page<BlogDivSidebar> page = new Page<BlogDivSidebar>(pageNo, pageSize);
		IPage<BlogDivSidebar> pageList = blogDivSidebarService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param blogDivSidebar
	 * @return
	 */
	@AutoLog(value = "自定义侧边栏-添加")
	@ApiOperation(value="自定义侧边栏-添加", notes="自定义侧边栏-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BlogDivSidebar blogDivSidebar) {
		blogDivSidebarService.save(blogDivSidebar);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param blogDivSidebar
	 * @return
	 */
	@AutoLog(value = "自定义侧边栏-编辑")
	@ApiOperation(value="自定义侧边栏-编辑", notes="自定义侧边栏-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BlogDivSidebar blogDivSidebar) {
		blogDivSidebarService.updateById(blogDivSidebar);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "自定义侧边栏-通过id删除")
	@ApiOperation(value="自定义侧边栏-通过id删除", notes="自定义侧边栏-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		blogDivSidebarService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "自定义侧边栏-批量删除")
	@ApiOperation(value="自定义侧边栏-批量删除", notes="自定义侧边栏-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.blogDivSidebarService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "自定义侧边栏-通过id查询")
	@ApiOperation(value="自定义侧边栏-通过id查询", notes="自定义侧边栏-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BlogDivSidebar> queryById(@RequestParam(name="id",required=true) String id) {
		BlogDivSidebar blogDivSidebar = blogDivSidebarService.getById(id);
		if(blogDivSidebar==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(blogDivSidebar);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param blogDivSidebar
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BlogDivSidebar blogDivSidebar) {
        return super.exportXls(request, blogDivSidebar, BlogDivSidebar.class, "自定义侧边栏");
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
        return super.importExcel(request, response, BlogDivSidebar.class);
    }

}
