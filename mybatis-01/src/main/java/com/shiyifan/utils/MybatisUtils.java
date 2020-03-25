package com.shiyifan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlsessionfactory->sqlsession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //ʹ��mybatis��һ�� ��ȡsqlsessionfactory����
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //��Ȼ�����ַ�ʽ�ܹ�������������ʹ�þɰ汾 MyBatis ���û���˵Ҳ�Ƚ���Ϥ��
    // ����������һ�ָ����ķ�ʽ����ʹ�ú�ָ�����Ĳ����ͷ���ֵ��ƥ��Ľӿڣ����� BlogMapper.class����
    // ������Ĵ��벻�����������������Ͱ�ȫ�������õ��Ŀ��ܳ�����ַ�������ֵ�Լ�ǿ������ת����
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
