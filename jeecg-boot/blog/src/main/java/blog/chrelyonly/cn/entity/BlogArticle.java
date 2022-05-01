package blog.chrelyonly.cn.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 博客文章
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Data
@TableName("blog_article")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="blog_article对象", description="博客文章")
public class BlogArticle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**文章标题*/
	@Excel(name = "文章标题", width = 15)
    @ApiModelProperty(value = "文章标题")
    private java.lang.String articleName;
	/**文章logo*/
	@Excel(name = "文章logo", width = 15)
    @ApiModelProperty(value = "文章logo")
    private java.lang.String articleLogo;
	/**文章内容*/
	@Excel(name = "文章内容", width = 15)
    @ApiModelProperty(value = "文章内容")
    private java.lang.String articleText;
}
