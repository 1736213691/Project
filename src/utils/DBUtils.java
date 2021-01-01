package utils;

import bean.Vote;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class DBUtils {

    public static int cn=0;
    public static synchronized Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/web?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "");
            System.out.println("create DB connection - " + cn++);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    /**
     *
     * @return 数据库连接
     */
    public static synchronized Connection getConnection2() {
        DataSource ds = null;
        try {
            //读取配置文件
            Properties pro = new Properties();
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("data/db.properties");
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
            
            return ds.getConnection();
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 获取连接错误  %%%%%%%%%%%%%%");
        }
        return null;
    }

    /**
     *
     * @param clazz 查询的bean
     * @param sql   mysql查询语句
     * @param args  语句参数
     * @param <T>   bean
     * @return 结果集
     */
    public synchronized static <T> List<T> selectList(Class<T> clazz, String sql, Object...args){
            List<T> list = new ArrayList<T>();
            Connection con = null;
            PreparedStatement pdsm = null;
            ResultSet rs = null;
        try {
            con = getConnection();
            pdsm= con.prepareStatement(sql);
            for(int i = 0; i<args.length;i++) {
                //设置args参数
                pdsm.setObject(i + 1, args[i]);
            }
            rs = pdsm.executeQuery();
            //列信息
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int size = rsmd.getColumnCount();
            //封装
            while(rs.next()) {
                //利用反射创建实例
                T temp = clazz.newInstance();
                for (int i = 1; i <= size; i++) {
                    String key = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(key);
                    String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                    Method method = clazz.getMethod(methodName, value.getClass());
                    method.invoke(temp,value);
                }
                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           close(con, pdsm, rs);
        }
        return list;
    }

    public synchronized static <T> T selectOne(Class<T> clazz, String sql, Object...args){
        Connection con = null;
        PreparedStatement pdsm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pdsm= con.prepareStatement(sql);
            for(int i = 0; i<args.length;i++) {
                //设置args参数
                pdsm.setObject(i + 1, args[i]);
            }
            rs = pdsm.executeQuery();
            //列信息
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int size = rsmd.getColumnCount();
            //封装
            if(rs.next()) {
                //利用反射创建实例
                T temp = clazz.newInstance();

                for (int i = 1; i <= size; i++) {
                    String key = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(key);

                    String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                    Method method = clazz.getMethod(methodName, value.getClass());
                    method.invoke(temp,value);
                }
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pdsm, rs);
        }
        return null;
    }

    public static synchronized boolean add(Integer id){

        String countSql = "select count from votes where id =" + id;
        String sql = "update votes set count = ? where id =" + id;
        Connection con = null;
        PreparedStatement pdsm = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            pdsm = con.prepareStatement(countSql);
            rs = pdsm.executeQuery();
            if(rs.next()) {
                pdsm = con.prepareStatement(sql);
                pdsm.setInt(1, rs.getInt("count")+1);
                pdsm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pdsm, rs);
        }
        return false;
    }

    public static synchronized boolean insert(String sql, Object...args){
        Connection con = null;
        PreparedStatement pdsm = null;
        try {
            con = getConnection();
            pdsm= con.prepareStatement(sql);
            for(int i = 0; i<args.length;i++) {
                //设置args参数
                pdsm.setObject(i + 1, args[i]);
            }
            pdsm.executeUpdate();
            return true;
    } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pdsm, null);
        }
        return false;
    }

    /**
     * 关闭数据库资源
     * @param conn
     * @param stm
     * @param rs
     */
    public static synchronized void close(Connection conn, Statement stm, ResultSet rs) {
        try {
            if(conn!=null) conn.close();
            if(stm!=null) stm.close();
            if(rs!=null) rs.close();
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 关闭连接错误  %%%%%%%%%%%%%%");
            e.printStackTrace();
        }
    }

    public static synchronized <T> int getCount(Class<T> Class, String sql, Object...args) {
        Connection con = null;
        PreparedStatement pdsm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pdsm= con.prepareStatement(sql);
            for(int i = 0; i<args.length;i++) {
                //设置args参数
                pdsm.setObject(i + 1, args[i]);
            }
            rs = pdsm.executeQuery();
            //封装
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pdsm, rs);
        }
        return 0;
    }
}