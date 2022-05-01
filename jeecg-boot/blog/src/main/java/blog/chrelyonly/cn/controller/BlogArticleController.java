package blog.chrelyonly.cn.controller;

import blog.chrelyonly.cn.entity.BlogArticle;
import blog.chrelyonly.cn.service.IBlogArticleService;
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
 * @Description: 博客文章
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Api(tags="博客文章")
@RestController
@RequestMapping("/blog/blogArticle")
@Slf4j
@AllArgsConstructor
public class BlogArticleController extends JeecgController<BlogArticle, IBlogArticleService> {
	private final IBlogArticleService blogArticleService;

	/**
	 * 分页列表查询
	 *
	 * @param blogArticle
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "博客文章-分页列表查询")
	@ApiOperation(value="博客文章-分页列表查询", notes="博客文章-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BlogArticle>> queryPageList(BlogArticle blogArticle,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BlogArticle> queryWrapper = QueryGenerator.initQueryWrapper(blogArticle, req.getParameterMap());
		Page<BlogArticle> page = new Page<BlogArticle>(pageNo, pageSize);
		IPage<BlogArticle> pageList = blogArticleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param blogArticle
	 * @return
	 */
	@AutoLog(value = "博客文章-添加")
	@ApiOperation(value="博客文章-添加", notes="博客文章-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BlogArticle blogArticle) {
		blogArticleService.save(blogArticle);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param blogArticle
	 * @return
	 */
	@AutoLog(value = "博客文章-编辑")
	@ApiOperation(value="博客文章-编辑", notes="博客文章-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BlogArticle blogArticle) {
		blogArticleService.updateById(blogArticle);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "博客文章-通过id删除")
	@ApiOperation(value="博客文章-通过id删除", notes="博客文章-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		blogArticleService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "博客文章-批量删除")
	@ApiOperation(value="博客文章-批量删除", notes="博客文章-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.blogArticleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "博客文章-通过id查询")
	@ApiOperation(value="博客文章-通过id查询", notes="博客文章-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BlogArticle> queryById(@RequestParam(name="id",required=true) String id) {
		BlogArticle blogArticle = blogArticleService.getById(id);
		if(blogArticle==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(blogArticle);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param blogArticle
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BlogArticle blogArticle) {
        return super.exportXls(request, blogArticle, BlogArticle.class, "博客文章");
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
        return super.importExcel(request, response, BlogArticle.class);
    }

}
