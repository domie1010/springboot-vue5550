package com.entity.vo;

import com.entity.CaigoujihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备采购
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caigoujihua")
public class CaigoujihuaVO implements Serializable {
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
     * 采购数量
     */

    @TableField(value = "caigoujihua_number")
    private Integer caigoujihuaNumber;


    /**
     * 备注
     */

    @TableField(value = "caigoujihua_text")
    private String caigoujihuaText;


    /**
     * 申请状态
     */

    @TableField(value = "caigoujihua_yesno_types")
    private Integer caigoujihuaYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "caigoujihua_yesno_text")
    private String caigoujihuaYesnoText;


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
	 * 设置：采购数量
	 */
    public Integer getCaigoujihuaNumber() {
        return caigoujihuaNumber;
    }


    /**
	 * 获取：采购数量
	 */

    public void setCaigoujihuaNumber(Integer caigoujihuaNumber) {
        this.caigoujihuaNumber = caigoujihuaNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getCaigoujihuaText() {
        return caigoujihuaText;
    }


    /**
	 * 获取：备注
	 */

    public void setCaigoujihuaText(String caigoujihuaText) {
        this.caigoujihuaText = caigoujihuaText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getCaigoujihuaYesnoTypes() {
        return caigoujihuaYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setCaigoujihuaYesnoTypes(Integer caigoujihuaYesnoTypes) {
        this.caigoujihuaYesnoTypes = caigoujihuaYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getCaigoujihuaYesnoText() {
        return caigoujihuaYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setCaigoujihuaYesnoText(String caigoujihuaYesnoText) {
        this.caigoujihuaYesnoText = caigoujihuaYesnoText;
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
