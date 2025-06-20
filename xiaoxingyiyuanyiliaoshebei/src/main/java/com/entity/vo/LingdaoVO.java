package com.entity.vo;

import com.entity.LingdaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 领导
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lingdao")
public class LingdaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 领导名称
     */

    @TableField(value = "lingdao_name")
    private String lingdaoName;


    /**
     * 领导手机号
     */

    @TableField(value = "lingdao_phone")
    private String lingdaoPhone;


    /**
     * 领导身份证号
     */

    @TableField(value = "lingdao_id_number")
    private String lingdaoIdNumber;


    /**
     * 领导头像
     */

    @TableField(value = "lingdao_photo")
    private String lingdaoPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 领导邮箱
     */

    @TableField(value = "lingdao_email")
    private String lingdaoEmail;


    /**
     * 逻辑删除
     */

    @TableField(value = "lingdao_delete")
    private Integer lingdaoDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：领导名称
	 */
    public String getLingdaoName() {
        return lingdaoName;
    }


    /**
	 * 获取：领导名称
	 */

    public void setLingdaoName(String lingdaoName) {
        this.lingdaoName = lingdaoName;
    }
    /**
	 * 设置：领导手机号
	 */
    public String getLingdaoPhone() {
        return lingdaoPhone;
    }


    /**
	 * 获取：领导手机号
	 */

    public void setLingdaoPhone(String lingdaoPhone) {
        this.lingdaoPhone = lingdaoPhone;
    }
    /**
	 * 设置：领导身份证号
	 */
    public String getLingdaoIdNumber() {
        return lingdaoIdNumber;
    }


    /**
	 * 获取：领导身份证号
	 */

    public void setLingdaoIdNumber(String lingdaoIdNumber) {
        this.lingdaoIdNumber = lingdaoIdNumber;
    }
    /**
	 * 设置：领导头像
	 */
    public String getLingdaoPhoto() {
        return lingdaoPhoto;
    }


    /**
	 * 获取：领导头像
	 */

    public void setLingdaoPhoto(String lingdaoPhoto) {
        this.lingdaoPhoto = lingdaoPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：领导邮箱
	 */
    public String getLingdaoEmail() {
        return lingdaoEmail;
    }


    /**
	 * 获取：领导邮箱
	 */

    public void setLingdaoEmail(String lingdaoEmail) {
        this.lingdaoEmail = lingdaoEmail;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLingdaoDelete() {
        return lingdaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLingdaoDelete(Integer lingdaoDelete) {
        this.lingdaoDelete = lingdaoDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
