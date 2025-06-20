package com.dao;

import com.entity.KufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KufangView;

/**
 * 库房 Dao 接口
 *
 * @author 
 */
public interface KufangDao extends BaseMapper<KufangEntity> {

   List<KufangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
