/*
 * Copyright 1999-2023 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.plugin.datasource.impl.oracle;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.NamespaceUtil;
import com.alibaba.nacos.plugin.datasource.constants.DatabaseTypeConstant;
import com.alibaba.nacos.plugin.datasource.constants.FieldConstant;
import com.alibaba.nacos.plugin.datasource.impl.base.BaseTenantCapacityMapper;
import com.alibaba.nacos.plugin.datasource.mapper.TenantCapacityMapper;
import com.alibaba.nacos.plugin.datasource.model.MapperContext;
import com.alibaba.nacos.plugin.datasource.model.MapperResult;

import java.util.ArrayList;
import java.util.List;

/***
 * @author onewe
 */
public class TenantCapacityMapperByOracle extends BaseTenantCapacityMapper {

	@Override
	public String getDataSource() {
		return DatabaseTypeConstant.ORACLE;
	}

	@Override
	public MapperResult getCapacityList4CorrectUsage(MapperContext context) {
		String sql = "SELECT id, tenant_id " +
				"FROM tenant_capacity " +
				"WHERE id > ? " +
				"AND ROWNUM <= ?";
		return new MapperResult(sql, CollectionUtils.list(context.getWhereParameter(FieldConstant.ID),
				context.getWhereParameter(FieldConstant.LIMIT_SIZE)));
	}
}
