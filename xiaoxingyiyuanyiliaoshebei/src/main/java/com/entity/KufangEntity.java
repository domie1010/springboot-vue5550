package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 库房
 *
 * @author 
 * @email
 */
@TableName("kufang")
public class KufangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KufangEntity() {

	}

	public KufangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 库房编号
     */
    @ColumnInfo(comment="库房编号",type="varchar(200)")
    @TableField(value = "kufang_uuid_number")

    private String kufangUuidNumber;


    /**
     * 库房名称
     */
    @ColumnInfo(comment="库房名称",type="varchar(200)")
    @TableField(value = "kufang_name")

    private String kufangName;


    /**
     * 库房类型
     */
    @ColumnInfo(comment="库房类型",type="int(11)")
    @TableField(value = "kufang_types")

    private Integer kufangTypes;


    /**
     * 库房地址
     */
    @ColumnInfo(comment="库房地址",type="varchar(200)")
    @TableField(value = "kufang_address")

    private String kufangAddress;


    /**
     * 库房介绍
     */
    @ColumnInfo(comment="库房介绍",type="longtext")
    @TableField(value = "kufang_content")

    private String kufangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "kufang_delete")

    private Integer kufangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Kufang{" +
            ", id=" + id +
            ", kufangUuidNumber=" + kufangUuidNumber +
            ", kufangName=" + kufangName +
            ", kufangTypes=" + kufangTypes +
            ", kufangAddress=" + kufangAddress +
            ", kufangContent=" + kufangContent +
            ", kufangDelete=" + kufangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
