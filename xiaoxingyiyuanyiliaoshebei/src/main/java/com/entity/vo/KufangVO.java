package com.entity.vo;

import com.entity.KufangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 库房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kufang")
public class KufangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 库房编号
     */

    @TableField(value = "kufang_uuid_number")
    private String kufangUuidNumber;


    /**
     * 库房名称
     */

    @TableField(value = "kufang_name")
    private String kufangName;


    /**
     * 库房类型
     */

    @TableField(value = "kufang_types")
    private Integer kufangTypes;


    /**
     * 库房地址
     */

    @TableField(value = "kufang_address")
    private String kufangAddress;


    /**
     * 库房介绍
     */

    @TableField(value = "kufang_content")
    private String kufangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "kufang_delete")
    private Integer kufangDelete;


    /**
     * 录入时间
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
	 * 设置：库房编号
	 */
    public String getKufangUuidNumber() {
        return kufangUuidNumber;
    }


    /**
	 * 获取：库房编号
	 */

    public void setKufangUuidNumber(String kufangUuidNumber) {
        this.kufangUuidNumber = kufangUuidNumber;
    }
    /**
	 * 设置：库房名称
	 */
    public String getKufangName() {
        return kufangName;
    }


    /**
	 * 获取：库房名称
	 */

    public void setKufangName(String kufangName) {
        this.kufangName = kufangName;
    }
    /**
	 * 设置：库房类型
	 */
    public Integer getKufangTypes() {
        return kufangTypes;
    }


    /**
	 * 获取：库房类型
	 */

    public void setKufangTypes(Integer kufangTypes) {
        this.kufangTypes = kufangTypes;
    }
    /**
	 * 设置：库房地址
	 */
    public String getKufangAddress() {
        return kufangAddress;
    }


    /**
	 * 获取：库房地址
	 */

    public void setKufangAddress(String kufangAddress) {
        this.kufangAddress = kufangAddress;
    }
    /**
	 * 设置：库房介绍
	 */
    public String getKufangContent() {
        return kufangContent;
    }


    /**
	 * 获取：库房介绍
	 */

    public void setKufangContent(String kufangContent) {
        this.kufangContent = kufangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKufangDelete() {
        return kufangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setKufangDelete(Integer kufangDelete) {
        this.kufangDelete = kufangDelete;
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
