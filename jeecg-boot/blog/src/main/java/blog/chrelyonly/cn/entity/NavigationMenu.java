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
 * @Description: 导航栏菜单
 * @Author: jeecg-boot
 * @Date:   2022-05-01
 * @Version: V1.0
 */
@Data
@TableName("navigation_menu")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="navigation_menu对象", description="导航栏菜单")
public class NavigationMenu implements Serializable {
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
	/**标题*/
	@Excel(name = "标题", width = 15)
    @ApiModelProperty(value = "标题")
    private java.lang.String title;
	/**跳转路径*/
	@Excel(name = "跳转路径", width = 15)
    @ApiModelProperty(value = "跳转路径")
    private java.lang.String path;
	/**图标*/
	@Excel(name = "图标", width = 15)
    @ApiModelProperty(value = "图标")
    private java.lang.String icon;
	/**图标颜色*/
	@Excel(name = "图标颜色", width = 15)
    @ApiModelProperty(value = "图标颜色")
    private java.lang.String iconBgColor;
	/**父级id*/
	@Excel(name = "父级id", width = 15)
    @ApiModelProperty(value = "父级id")
    private java.lang.String parentId;
	/**子集*/
	@Excel(name = "子集", width = 15)
    @ApiModelProperty(value = "子集")
    private java.lang.String children;
	/**是否有子集*/
	@Excel(name = "是否有子集", width = 15)
    @ApiModelProperty(value = "是否有子集")
    private java.lang.String boobleChildren;
}
