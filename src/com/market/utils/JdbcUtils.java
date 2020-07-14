/**
 * 
 */
package com.market.utils;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据连接
 * @author ZH
 * 上午10:46:18
 */
public class JdbcUtils {
	//创建数据连接池
	public static ComboPooledDataSource ds = new ComboPooledDataSource();
	public static QueryRunner qr = new QueryRunner(ds);
}
