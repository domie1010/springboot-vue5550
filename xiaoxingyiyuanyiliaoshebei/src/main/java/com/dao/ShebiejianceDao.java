package com.dao;

import com.entity.ShebiejianceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebiejianceView;

/**
 * 质量检测登记 Dao 接口
 *
 * @author 
 */
public interface ShebiejianceDao extends BaseMapper<ShebiejianceEntity> {

   List<ShebiejianceView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
