package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShebeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 设备
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shebei")
public class ShebeiView extends ShebeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 设备类型的值
	*/
	@ColumnInfo(comment="设备类型的字典表值",type="varchar(200)")
	private String shebeiValue;
	/**
	* 所在科室的值
	*/
	@ColumnInfo(comment="所在科室的字典表值",type="varchar(200)")
	private String keshiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 库房
		/**
		* 库房编号
		*/

		@ColumnInfo(comment="库房编号",type="varchar(200)")
		private String kufangUuidNumber;
		/**
		* 库房名称
		*/

		@ColumnInfo(comment="库房名称",type="varchar(200)")
		private String kufangName;
		/**
		* 库房类型
		*/
		@ColumnInfo(comment="库房类型",type="int(11)")
		private Integer kufangTypes;
			/**
			* 库房类型的值
			*/
			@ColumnInfo(comment="库房类型的字典表值",type="varchar(200)")
			private String kufangValue;
		/**
		* 库房地址
		*/

		@ColumnInfo(comment="库房地址",type="varchar(200)")
		private String kufangAddress;
		/**
		* 库房介绍
		*/

		@ColumnInfo(comment="库房介绍",type="longtext")
		private String kufangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer kufangDelete;



	public ShebeiView() {

	}

	public ShebeiView(ShebeiEntity shebeiEntity) {
		try {
			BeanUtils.copyProperties(this, shebeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 设备类型的值
	*/
	public String getShebeiValue() {
		return shebeiValue;
	}
	/**
	* 设置： 设备类型的值
	*/
	public void setShebeiValue(String shebeiValue) {
		this.shebeiValue = shebeiValue;
	}
	//当前表的
	/**
	* 获取： 所在科室的值
	*/
	public String getKeshiValue() {
		return keshiValue;
	}
	/**
	* 设置： 所在科室的值
	*/
	public void setKeshiValue(String keshiValue) {
		this.keshiValue = keshiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}


	//级联表的get和set 库房

		/**
		* 获取： 库房编号
		*/
		public String getKufangUuidNumber() {
			return kufangUuidNumber;
		}
		/**
		* 设置： 库房编号
		*/
		public void setKufangUuidNumber(String kufangUuidNumber) {
			this.kufangUuidNumber = kufangUuidNumber;
		}

		/**
		* 获取： 库房名称
		*/
		public String getKufangName() {
			return kufangName;
		}
		/**
		* 设置： 库房名称
		*/
		public void setKufangName(String kufangName) {
			this.kufangName = kufangName;
		}
		/**
		* 获取： 库房类型
		*/
		public Integer getKufangTypes() {
			return kufangTypes;
		}
		/**
		* 设置： 库房类型
		*/
		public void setKufangTypes(Integer kufangTypes) {
			this.kufangTypes = kufangTypes;
		}


			/**
			* 获取： 库房类型的值
			*/
			public String getKufangValue() {
				return kufangValue;
			}
			/**
			* 设置： 库房类型的值
			*/
			public void setKufangValue(String kufangValue) {
				this.kufangValue = kufangValue;
			}

		/**
		* 获取： 库房地址
		*/
		public String getKufangAddress() {
			return kufangAddress;
		}
		/**
		* 设置： 库房地址
		*/
		public void setKufangAddress(String kufangAddress) {
			this.kufangAddress = kufangAddress;
		}

		/**
		* 获取： 库房介绍
		*/
		public String getKufangContent() {
			return kufangContent;
		}
		/**
		* 设置： 库房介绍
		*/
		public void setKufangContent(String kufangContent) {
			this.kufangContent = kufangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getKufangDelete() {
			return kufangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setKufangDelete(Integer kufangDelete) {
			this.kufangDelete = kufangDelete;
		}


	@Override
	public String toString() {
		return "ShebeiView{" +
			", shebeiValue=" + shebeiValue +
			", keshiValue=" + keshiValue +
			", shangxiaValue=" + shangxiaValue +
			", kufangUuidNumber=" + kufangUuidNumber +
			", kufangName=" + kufangName +
			", kufangAddress=" + kufangAddress +
			", kufangContent=" + kufangContent +
			", kufangDelete=" + kufangDelete +
			"} " + super.toString();
	}
}
