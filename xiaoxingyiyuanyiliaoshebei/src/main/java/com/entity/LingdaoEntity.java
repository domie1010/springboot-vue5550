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
 * 领导
 *
 * @author 
 * @email
 */
@TableName("lingdao")
public class LingdaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LingdaoEntity() {

	}

	public LingdaoEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 领导名称
     */
    @ColumnInfo(comment="领导名称",type="varchar(200)")
    @TableField(value = "lingdao_name")

    private String lingdaoName;


    /**
     * 领导手机号
     */
    @ColumnInfo(comment="领导手机号",type="varchar(200)")
    @TableField(value = "lingdao_phone")

    private String lingdaoPhone;


    /**
     * 领导身份证号
     */
    @ColumnInfo(comment="领导身份证号",type="varchar(200)")
    @TableField(value = "lingdao_id_number")

    private String lingdaoIdNumber;


    /**
     * 领导头像
     */
    @ColumnInfo(comment="领导头像",type="varchar(200)")
    @TableField(value = "lingdao_photo")

    private String lingdaoPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 领导邮箱
     */
    @ColumnInfo(comment="领导邮箱",type="varchar(200)")
    @TableField(value = "lingdao_email")

    private String lingdaoEmail;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "lingdao_delete")

    private Integer lingdaoDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：领导名称
	 */
    public String getLingdaoName() {
        return lingdaoName;
    }
    /**
	 * 设置：领导名称
	 */

    public void setLingdaoName(String lingdaoName) {
        this.lingdaoName = lingdaoName;
    }
    /**
	 * 获取：领导手机号
	 */
    public String getLingdaoPhone() {
        return lingdaoPhone;
    }
    /**
	 * 设置：领导手机号
	 */

    public void setLingdaoPhone(String lingdaoPhone) {
        this.lingdaoPhone = lingdaoPhone;
    }
    /**
	 * 获取：领导身份证号
	 */
    public String getLingdaoIdNumber() {
        return lingdaoIdNumber;
    }
    /**
	 * 设置：领导身份证号
	 */

    public void setLingdaoIdNumber(String lingdaoIdNumber) {
        this.lingdaoIdNumber = lingdaoIdNumber;
    }
    /**
	 * 获取：领导头像
	 */
    public String getLingdaoPhoto() {
        return lingdaoPhoto;
    }
    /**
	 * 设置：领导头像
	 */

    public void setLingdaoPhoto(String lingdaoPhoto) {
        this.lingdaoPhoto = lingdaoPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：领导邮箱
	 */
    public String getLingdaoEmail() {
        return lingdaoEmail;
    }
    /**
	 * 设置：领导邮箱
	 */

    public void setLingdaoEmail(String lingdaoEmail) {
        this.lingdaoEmail = lingdaoEmail;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLingdaoDelete() {
        return lingdaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setLingdaoDelete(Integer lingdaoDelete) {
        this.lingdaoDelete = lingdaoDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
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
        return "Lingdao{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", lingdaoName=" + lingdaoName +
            ", lingdaoPhone=" + lingdaoPhone +
            ", lingdaoIdNumber=" + lingdaoIdNumber +
            ", lingdaoPhoto=" + lingdaoPhoto +
            ", sexTypes=" + sexTypes +
            ", lingdaoEmail=" + lingdaoEmail +
            ", lingdaoDelete=" + lingdaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
