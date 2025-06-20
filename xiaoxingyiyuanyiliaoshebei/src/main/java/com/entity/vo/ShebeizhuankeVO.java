package com.entity.vo;

import com.entity.ShebeizhuankeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备转科
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebeizhuanke")
public class ShebeizhuankeVO implements Serializable {
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
     * 要转的科室
     */

    @TableField(value = "keshi_types")
    private Integer keshiTypes;


    /**
     * 备注
     */

    @TableField(value = "shebeizhuanke_text")
    private String shebeizhuankeText;


    /**
     * 申请状态
     */

    @TableField(value = "shebeizhuanke_yesno_types")
    private Integer shebeizhuankeYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "shebeizhuanke_yesno_text")
    private String shebeizhuankeYesnoText;


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
	 * 设置：要转的科室
	 */
    public Integer getKeshiTypes() {
        return keshiTypes;
    }


    /**
	 * 获取：要转的科室
	 */

    public void setKeshiTypes(Integer keshiTypes) {
        this.keshiTypes = keshiTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getShebeizhuankeText() {
        return shebeizhuankeText;
    }


    /**
	 * 获取：备注
	 */

    public void setShebeizhuankeText(String shebeizhuankeText) {
        this.shebeizhuankeText = shebeizhuankeText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getShebeizhuankeYesnoTypes() {
        return shebeizhuankeYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setShebeizhuankeYesnoTypes(Integer shebeizhuankeYesnoTypes) {
        this.shebeizhuankeYesnoTypes = shebeizhuankeYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getShebeizhuankeYesnoText() {
        return shebeizhuankeYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setShebeizhuankeYesnoText(String shebeizhuankeYesnoText) {
        this.shebeizhuankeYesnoText = shebeizhuankeYesnoText;
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
