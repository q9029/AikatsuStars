package com.github.q9029.aikatsustars.dao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.github.q9029.aikatsustars.dao.exception.SqlLoadException;

public class SqlUtil {

    private static Map<Class<?>, Map<String, String>> sqlMap = new HashMap<Class<?>, Map<String, String>>();

    public static String getSql(Class<?> clazz, String method) {

        // classが登録されていない場合
        if (sqlMap.get(clazz) == null) {
            // classを追加する
            sqlMap.put(clazz, new HashMap<String, String>());
        }

        // methodが登録されていない場合
        if (sqlMap.get(clazz).get(method) == null) {

            // クラスパス作成
            String fileName = new StringBuilder().append("META-INF/").append(clazz.toString().replace('.', '/')).append(method).append(".sql").toString();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(SqlUtil.class.getClassLoader().getResourceAsStream(fileName)))) {

                StringBuilder sb = new StringBuilder();

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                // methodを追加する
                sqlMap.get(clazz).put(method, sb.toString());

            } catch (IOException e) {
                throw new SqlLoadException(e);
            }
        }

        // 返却
        return sqlMap.get(clazz).get(method);
    }
}
