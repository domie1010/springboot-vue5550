package com.dao;

import com.entity.ShebiebaosunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebiebaosunView;

/**
 * 设备报损 Dao 接口
 *
 * @author 
 */
public interface ShebiebaosunDao extends BaseMapper<ShebiebaosunEntity> {

   List<ShebiebaosunView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
