package com.cc.projetX.service.util;


public class StringUtil {

public static boolean isEmpty(String string) {
return string == null || string.isEmpty();
}

public static boolean isNotEmpty(String string) {
return !isEmpty(string);
}
}
