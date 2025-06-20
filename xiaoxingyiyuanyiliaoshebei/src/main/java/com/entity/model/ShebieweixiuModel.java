package com.entity.model;

import com.entity.ShebieweixiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备维修
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebieweixiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设备
     */
    private Integer shebeiId;


    /**
     * 科室职员
     */
    private Integer yonghuId;


    /**
     * 维修数量
     */
    private Integer shebieweixiuNumber;


    /**
     * 备注
     */
    private String shebieweixiuText;


    /**
     * 申请状态
     */
    private Integer shebieweixiuYesnoTypes;


    /**
     * 申请结果
     */
    private String shebieweixiuYesnoText;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：设备
	 */
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 设置：设备
	 */
    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 获取：科室职员
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：科室职员
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：维修数量
	 */
    public Integer getShebieweixiuNumber() {
        return shebieweixiuNumber;
    }


    /**
	 * 设置：维修数量
	 */
    public void setShebieweixiuNumber(Integer shebieweixiuNumber) {
        this.shebieweixiuNumber = shebieweixiuNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getShebieweixiuText() {
        return shebieweixiuText;
    }


    /**
	 * 设置：备注
	 */
    public void setShebieweixiuText(String shebieweixiuText) {
        this.shebieweixiuText = shebieweixiuText;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShebieweixiuYesnoTypes() {
        return shebieweixiuYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setShebieweixiuYesnoTypes(Integer shebieweixiuYesnoTypes) {
        this.shebieweixiuYesnoTypes = shebieweixiuYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getShebieweixiuYesnoText() {
        return shebieweixiuYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setShebieweixiuYesnoText(String shebieweixiuYesnoText) {
        this.shebieweixiuYesnoText = shebieweixiuYesnoText;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
