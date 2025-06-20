package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShebeizhuankeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 设备转科
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shebeizhuanke")
public class ShebeizhuankeView extends ShebeizhuankeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 要转的科室的值
	*/
	@ColumnInfo(comment="要转的科室的字典表值",type="varchar(200)")
	private String keshiValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String shebeizhuankeYesnoValue;

	//级联表 设备
		/**
		* 设备编号
		*/

		@ColumnInfo(comment="设备编号",type="varchar(200)")
		private String shebeiUuidNumber;
		/**
		* 设备名称
		*/

		@ColumnInfo(comment="设备名称",type="varchar(200)")
		private String shebeiName;
		/**
		* 设备类型
		*/
		@ColumnInfo(comment="设备类型",type="int(11)")
		private Integer shebeiTypes;
			/**
			* 设备类型的值
			*/
			@ColumnInfo(comment="设备类型的字典表值",type="varchar(200)")
			private String shebeiValue;
		/**
		* 设备库存
		*/

		@ColumnInfo(comment="设备库存",type="int(11)")
		private Integer shebeiKucunNumber;
							/**
		* 设备介绍
		*/

		@ColumnInfo(comment="设备介绍",type="longtext")
		private String shebeiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shebeiDelete;
	//级联表 科室职员
		/**
		* 职员名称
		*/

		@ColumnInfo(comment="职员名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 职员手机号
		*/

		@ColumnInfo(comment="职员手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 职员身份证号
		*/

		@ColumnInfo(comment="职员身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 职员头像
		*/

		@ColumnInfo(comment="职员头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 职员邮箱
		*/

		@ColumnInfo(comment="职员邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;

	//重复字段


	public ShebeizhuankeView() {

	}

	public ShebeizhuankeView(ShebeizhuankeEntity shebeizhuankeEntity) {
		try {
			BeanUtils.copyProperties(this, shebeizhuankeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 要转的科室的值
	*/
	public String getKeshiValue() {
		return keshiValue;
	}
	/**
	* 设置： 要转的科室的值
	*/
	public void setKeshiValue(String keshiValue) {
		this.keshiValue = keshiValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getShebeizhuankeYesnoValue() {
		return shebeizhuankeYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setShebeizhuankeYesnoValue(String shebeizhuankeYesnoValue) {
		this.shebeizhuankeYesnoValue = shebeizhuankeYesnoValue;
	}


	//级联表的get和set 设备

		/**
		* 获取： 设备编号
		*/
		public String getShebeiUuidNumber() {
			return shebeiUuidNumber;
		}
		/**
		* 设置： 设备编号
		*/
		public void setShebeiUuidNumber(String shebeiUuidNumber) {
			this.shebeiUuidNumber = shebeiUuidNumber;
		}

		/**
		* 获取： 设备名称
		*/
		public String getShebeiName() {
			return shebeiName;
		}
		/**
		* 设置： 设备名称
		*/
		public void setShebeiName(String shebeiName) {
			this.shebeiName = shebeiName;
		}
		/**
		* 获取： 设备类型
		*/
		public Integer getShebeiTypes() {
			return shebeiTypes;
		}
		/**
		* 设置： 设备类型
		*/
		public void setShebeiTypes(Integer shebeiTypes) {
			this.shebeiTypes = shebeiTypes;
		}


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

		/**
		* 获取： 设备库存
		*/
		public Integer getShebeiKucunNumber() {
			return shebeiKucunNumber;
		}
		/**
		* 设置： 设备库存
		*/
		public void setShebeiKucunNumber(Integer shebeiKucunNumber) {
			this.shebeiKucunNumber = shebeiKucunNumber;
		}

		/**
		* 获取： 设备介绍
		*/
		public String getShebeiContent() {
			return shebeiContent;
		}
		/**
		* 设置： 设备介绍
		*/
		public void setShebeiContent(String shebeiContent) {
			this.shebeiContent = shebeiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShebeiDelete() {
			return shebeiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShebeiDelete(Integer shebeiDelete) {
			this.shebeiDelete = shebeiDelete;
		}
	//级联表的get和set 科室职员

		/**
		* 获取： 职员名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 职员名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 职员手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 职员手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 职员身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 职员身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 职员头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 职员头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 职员邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 职员邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}

	//重复字段

	@Override
	public String toString() {
		return "ShebeizhuankeView{" +
			", keshiValue=" + keshiValue +
			", shebeizhuankeYesnoValue=" + shebeizhuankeYesnoValue +
			", shebeiUuidNumber=" + shebeiUuidNumber +
			", shebeiName=" + shebeiName +
			", shebeiKucunNumber=" + shebeiKucunNumber +
			", shebeiContent=" + shebeiContent +
			", shebeiDelete=" + shebeiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
