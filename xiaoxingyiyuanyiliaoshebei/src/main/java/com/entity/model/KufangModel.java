package com.entity.model;

import com.entity.KufangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 库房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KufangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 库房编号
     */
    private String kufangUuidNumber;


    /**
     * 库房名称
     */
    private String kufangName;


    /**
     * 库房类型
     */
    private Integer kufangTypes;


    /**
     * 库房地址
     */
    private String kufangAddress;


    /**
     * 库房介绍
     */
    private String kufangContent;


    /**
     * 逻辑删除
     */
    private Integer kufangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：库房编号
	 */
    public String getKufangUuidNumber() {
        return kufangUuidNumber;
    }


    /**
	 * 设置：库房编号
	 */
    public void setKufangUuidNumber(String kufangUuidNumber) {
        this.kufangUuidNumber = kufangUuidNumber;
    }
    /**
	 * 获取：库房名称
	 */
    public String getKufangName() {
        return kufangName;
    }


    /**
	 * 设置：库房名称
	 */
    public void setKufangName(String kufangName) {
        this.kufangName = kufangName;
    }
    /**
	 * 获取：库房类型
	 */
    public Integer getKufangTypes() {
        return kufangTypes;
    }


    /**
	 * 设置：库房类型
	 */
    public void setKufangTypes(Integer kufangTypes) {
        this.kufangTypes = kufangTypes;
    }
    /**
	 * 获取：库房地址
	 */
    public String getKufangAddress() {
        return kufangAddress;
    }


    /**
	 * 设置：库房地址
	 */
    public void setKufangAddress(String kufangAddress) {
        this.kufangAddress = kufangAddress;
    }
    /**
	 * 获取：库房介绍
	 */
    public String getKufangContent() {
        return kufangContent;
    }


    /**
	 * 设置：库房介绍
	 */
    public void setKufangContent(String kufangContent) {
        this.kufangContent = kufangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKufangDelete() {
        return kufangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setKufangDelete(Integer kufangDelete) {
        this.kufangDelete = kufangDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
