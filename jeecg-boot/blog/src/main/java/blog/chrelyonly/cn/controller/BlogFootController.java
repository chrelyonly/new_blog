package blog.chrelyonly.cn.controller;

import blog.chrelyonly.cn.entity.BlogFoot;
import blog.chrelyonly.cn.service.IBlogFootService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 底部备案等作者等信息
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Api(tags="底部备案等作者等信息")
@RestController
@RequestMapping("/blog/blogFoot")
@Slf4j
@AllArgsConstructor
public class BlogFootController extends JeecgController<BlogFoot, IBlogFootService> {
	private final IBlogFootService blogFootService;

	/**
	 * 分页列表查询
	 *
	 * @param blogFoot
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "底部备案等作者等信息-分页列表查询")
	@ApiOperation(value="底部备案等作者等信息-分页列表查询", notes="底部备案等作者等信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BlogFoot>> queryPageList(BlogFoot blogFoot,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BlogFoot> queryWrapper = QueryGenerator.initQueryWrapper(blogFoot, req.getParameterMap());
		Page<BlogFoot> page = new Page<BlogFoot>(pageNo, pageSize);
		IPage<BlogFoot> pageList = blogFootService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 *   添加
	 *
	 * @param blogFoot
	 * @return
	 */
	@AutoLog(value = "底部备案等作者等信息-添加")
	@ApiOperation(value="底部备案等作者等信息-添加", notes="底部备案等作者等信息-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BlogFoot blogFoot) {
		blogFootService.save(blogFoot);
		return Result.OK("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param blogFoot
	 * @return
	 */
	@AutoLog(value = "底部备案等作者等信息-编辑")
	@ApiOperation(value="底部备案等作者等信息-编辑", notes="底部备案等作者等信息-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BlogFoot blogFoot) {
		blogFootService.updateById(blogFoot);
		return Result.OK("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "底部备案等作者等信息-通过id删除")
	@ApiOperation(value="底部备案等作者等信息-通过id删除", notes="底部备案等作者等信息-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		blogFootService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "底部备案等作者等信息-批量删除")
	@ApiOperation(value="底部备案等作者等信息-批量删除", notes="底部备案等作者等信息-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.blogFootService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "底部备案等作者等信息-通过id查询")
	@ApiOperation(value="底部备案等作者等信息-通过id查询", notes="底部备案等作者等信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BlogFoot> queryById(@RequestParam(name="id",required=true) String id) {
		BlogFoot blogFoot = blogFootService.getById(id);
		if(blogFoot==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(blogFoot);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param blogFoot
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BlogFoot blogFoot) {
        return super.exportXls(request, blogFoot, BlogFoot.class, "底部备案等作者等信息");
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
        return super.importExcel(request, response, BlogFoot.class);
    }

}
