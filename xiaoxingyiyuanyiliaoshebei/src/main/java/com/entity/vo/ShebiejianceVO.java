package com.entity.vo;

import com.entity.ShebiejianceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 质量检测登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebiejiance")
public class ShebiejianceVO implements Serializable {
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
     * 质量检测登记数量
     */

    @TableField(value = "shebiejiance_number")
    private Integer shebiejianceNumber;


    /**
     * 备注
     */

    @TableField(value = "shebiejiance_text")
    private String shebiejianceText;


    /**
     * 申请状态
     */

    @TableField(value = "shebiejiance_yesno_types")
    private Integer shebiejianceYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "shebiejiance_yesno_text")
    private String shebiejianceYesnoText;


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
	 * 设置：质量检测登记数量
	 */
    public Integer getShebiejianceNumber() {
        return shebiejianceNumber;
    }


    /**
	 * 获取：质量检测登记数量
	 */

    public void setShebiejianceNumber(Integer shebiejianceNumber) {
        this.shebiejianceNumber = shebiejianceNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getShebiejianceText() {
        return shebiejianceText;
    }


    /**
	 * 获取：备注
	 */

    public void setShebiejianceText(String shebiejianceText) {
        this.shebiejianceText = shebiejianceText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShebiejianceYesnoTypes() {
        return shebiejianceYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShebiejianceYesnoTypes(Integer shebiejianceYesnoTypes) {
        this.shebiejianceYesnoTypes = shebiejianceYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getShebiejianceYesnoText() {
        return shebiejianceYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setShebiejianceYesnoText(String shebiejianceYesnoText) {
        this.shebiejianceYesnoText = shebiejianceYesnoText;
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
