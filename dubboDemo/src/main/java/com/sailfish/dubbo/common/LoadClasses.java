package com.sailfish.dubbo.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.common
 * @Description:
 * @date 2020/6/6 4:54 下午
 */
public class LoadClasses {


    private static final String SERVICES_DIRECTORY = "META-INF/dubbo/";
    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");
    private Class<?> type;

    public Map<String, Class<?>> loadClasses(Class<?> type) {
        this.type = type;
        Map<String, Class<?>> extensionClasses = new HashMap<String, Class<?>>();
        loadDirectory(extensionClasses, SERVICES_DIRECTORY);
        return extensionClasses;
    }

    private void loadDirectory(Map<String, Class<?>> classes, String dir) {
        String fileName = dir + type.getName();
        Enumeration<URL> urls;
        final ClassLoader classLoader = findClassLoader();
        try {
            if (classLoader != null) {
                urls = classLoader.getResources(fileName);
            } else {
                urls = ClassLoader.getSystemResources(fileName);
            }

            if (urls != null) {
                while (urls.hasMoreElements()) {
                    java.net.URL resourceURL = urls.nextElement();
                    loadResource(classes, classLoader, resourceURL);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadResource(Map<String, Class<?>> classes, ClassLoader classLoader, URL resourceURL) {
        try {
            final InputStreamReader reader = new InputStreamReader(resourceURL.openStream(), "utf-8");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                final int ci = line.indexOf("#");
                if (ci >= 0) {
                    line = line.substring(0, ci);
                }
                line = line.trim();
                if (line.length() > 0) {
                    try {
                        String name = null;
                        final int i = line.indexOf("=");
                        if (i > 0) {
                            name = line.substring(0, i).trim();
                            line = line.substring(i + 1).trim();
                        }
                        if (line.length() > 0) {
                            loadClass(classes, resourceURL, Class.forName(line, true, classLoader), name);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadClass(Map<String, Class<?>> classes, URL resourceURL, Class<?> clazz, String name) throws NoSuchMethodException {
        if (!type.isAssignableFrom(clazz)) {
            throw new IllegalStateException("Error clazz state");
        }
        clazz.getConstructor();
        final String[] names = NAME_SEPARATOR.split(name);
        if (names != null && names.length > 0) {
            for (String n : names) {
                final Class<?> c = classes.get(n);
                if (c == null) {
                    classes.put(n, clazz);
                }
            }
        }
    }


    private static ClassLoader findClassLoader() {
        return LoadClasses.class.getClassLoader();
    }

}
