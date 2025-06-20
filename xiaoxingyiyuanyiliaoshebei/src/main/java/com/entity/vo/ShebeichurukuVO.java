package com.entity.vo;

import com.entity.ShebeichurukuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备出入库房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebeichuruku")
public class ShebeichurukuVO implements Serializable {
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
     * 出入库类型
     */

    @TableField(value = "shebeichuruku_types")
    private Integer shebeichurukuTypes;


    /**
     * 出入库数量
     */

    @TableField(value = "shebeichuruku_number")
    private Integer shebeichurukuNumber;


    /**
     * 备注
     */

    @TableField(value = "shebeichuruku_text")
    private String shebeichurukuText;


    /**
     * 申请状态
     */

    @TableField(value = "shebeichuruku_yesno_types")
    private Integer shebeichurukuYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "shebeichuruku_yesno_text")
    private String shebeichurukuYesnoText;


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
	 * 设置：出入库类型
	 */
    public Integer getShebeichurukuTypes() {
        return shebeichurukuTypes;
    }


    /**
	 * 获取：出入库类型
	 */

    public void setShebeichurukuTypes(Integer shebeichurukuTypes) {
        this.shebeichurukuTypes = shebeichurukuTypes;
    }
    /**
	 * 设置：出入库数量
	 */
    public Integer getShebeichurukuNumber() {
        return shebeichurukuNumber;
    }


    /**
	 * 获取：出入库数量
	 */

    public void setShebeichurukuNumber(Integer shebeichurukuNumber) {
        this.shebeichurukuNumber = shebeichurukuNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getShebeichurukuText() {
        return shebeichurukuText;
    }


    /**
	 * 获取：备注
	 */

    public void setShebeichurukuText(String shebeichurukuText) {
        this.shebeichurukuText = shebeichurukuText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShebeichurukuYesnoTypes() {
        return shebeichurukuYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShebeichurukuYesnoTypes(Integer shebeichurukuYesnoTypes) {
        this.shebeichurukuYesnoTypes = shebeichurukuYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getShebeichurukuYesnoText() {
        return shebeichurukuYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setShebeichurukuYesnoText(String shebeichurukuYesnoText) {
        this.shebeichurukuYesnoText = shebeichurukuYesnoText;
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
