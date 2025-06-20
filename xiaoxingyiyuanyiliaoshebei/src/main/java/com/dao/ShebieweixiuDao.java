package com.dao;

import com.entity.ShebieweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebieweixiuView;

/**
 * 设备维修 Dao 接口
 *
 * @author 
 */
public interface ShebieweixiuDao extends BaseMapper<ShebieweixiuEntity> {

   List<ShebieweixiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
