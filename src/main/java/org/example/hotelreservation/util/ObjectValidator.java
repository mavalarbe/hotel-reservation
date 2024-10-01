package org.example.hotelreservation.util;

import java.util.List;

public class ObjectValidator {

    public static Boolean isEmpty(List<?> list) {
        return isNull(list) || list.isEmpty() || list.size() == 0;
    }

    public static Boolean isNull(Object obj) {
        return java.util.Objects.isNull(obj);
    }

}
