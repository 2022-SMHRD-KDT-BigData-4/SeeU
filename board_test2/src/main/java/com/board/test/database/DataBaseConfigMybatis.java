package com.board.test.database;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // ��������
@EnableTransactionManagement // Ʈ������ ����
@MapperScan(basePackages = "com.board.test.mapper")
public class DataBaseConfigMybatis {
	
	@Bean
	public DataSource batisDataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setJdbcUrl("jdbc:mysql://project-db-stu.ddns.net:3307/seeu");
		dataSourceConfig.setUsername("seeu");
		dataSourceConfig.setPassword("12345");
		dataSourceConfig.setMaximumPoolSize(10);
		dataSourceConfig.setMinimumIdle(5);
		dataSourceConfig.setMaxLifetime(1200000);
		dataSourceConfig.setConnectionTimeout(20000);
		dataSourceConfig.setIdleTimeout(300000);
		
		return new HikariDataSource(dataSourceConfig);
	}
	
	//�����ͺ��̽����� ����� SQL�� ���࿡ ���� ��� ���� ���� ���� �߿��� ��ü
	@Bean(name="batisSqlSessionFactory")
	public SqlSessionFactory batisSqlSessionFactory(@Qualifier("batisDataSource") DataSource batisDataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSession = new SqlSessionFactoryBean();
		sqlSession.setDataSource(batisDataSource);
		sqlSession.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml")); //mybatis-config.xml�� ���
		sqlSession.setMapperLocations(applicationContext.getResources("classpath:/com/board/test/mapper/BoardMapper.xml")); //�������� �����ϴ� mapper�� ���
		sqlSession.setMapperLocations(applicationContext.getResources("classpath:/com/board/test/mapper/CommentMapper.xml"));
		return sqlSession.getObject();
	}
	
	// ���̹�Ƽ�� ������ ��������� �ٽ�
	@Bean(name = "batisSqlSessionTemplate")
	public SqlSessionTemplate batSessionTemplate(SqlSessionFactory batisSqlSessionFactory) throws Exception {
		
		return new SqlSessionTemplate(batisSqlSessionFactory);
	}
	
}
