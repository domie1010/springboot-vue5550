package com.entity.vo;

import com.entity.ShebiebaosunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备报损
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebiebaosun")
public class ShebiebaosunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 设备
     */

    @TableField(value = "shebei_id")
    private Integer shebeiId;


    /**
     * 科室职员
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报损数量
     */

    @TableField(value = "shebiebaosun_number")
    private Integer shebiebaosunNumber;


    /**
     * 备注
     */

    @TableField(value = "shebiebaosun_text")
    private String shebiebaosunText;


    /**
     * 申请状态
     */

    @TableField(value = "shebiebaosun_yesno_types")
    private Integer shebiebaosunYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "shebiebaosun_yesno_text")
    private String shebiebaosunYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：设备
	 */
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 获取：设备
	 */

    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 设置：科室职员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：科室职员
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报损数量
	 */
    public Integer getShebiebaosunNumber() {
        return shebiebaosunNumber;
    }


    /**
	 * 获取：报损数量
	 */

    public void setShebiebaosunNumber(Integer shebiebaosunNumber) {
        this.shebiebaosunNumber = shebiebaosunNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getShebiebaosunText() {
        return shebiebaosunText;
    }


    /**
	 * 获取：备注
	 */

    public void setShebiebaosunText(String shebiebaosunText) {
        this.shebiebaosunText = shebiebaosunText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShebiebaosunYesnoTypes() {
        return shebiebaosunYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShebiebaosunYesnoTypes(Integer shebiebaosunYesnoTypes) {
        this.shebiebaosunYesnoTypes = shebiebaosunYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getShebiebaosunYesnoText() {
        return shebiebaosunYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setShebiebaosunYesnoText(String shebiebaosunYesnoText) {
        this.shebiebaosunYesnoText = shebiebaosunYesnoText;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
