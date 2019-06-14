package com.action.myboot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.action.myboot.pojo.SexEnum;

public class GenderTypeHandler extends BaseTypeHandler<SexEnum>{

	@Override
	public SexEnum getNullableResult(ResultSet rs, String col) throws SQLException {
		  int sex = rs.getInt(col);
	        if (sex != 1 && sex != 2) {
	            return null;
	        }
	        return SexEnum.getEnumById(sex);
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int col) throws SQLException {
		// TODO Auto-generated method stub
		int sex = rs.getInt(col);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
	}

	@Override
	public SexEnum getNullableResult(CallableStatement cs, int idx) throws SQLException {
		// TODO Auto-generated method stub
		int sex = cs.getInt(idx);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int idx, SexEnum sex, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		 ps.setInt(idx, sex.getId());
	}

}
