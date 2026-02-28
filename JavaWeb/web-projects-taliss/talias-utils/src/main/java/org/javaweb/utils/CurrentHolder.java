package org.javaweb.utils;

public class CurrentHolder {
    private static final ThreadLocal<Integer> CURRENT_EMP_ID = new ThreadLocal<>();

    public static void setCurrentEmpId(Integer empId) {
        CURRENT_EMP_ID.set(empId);
    }

    public static Integer getCurrentEmpId() {
        return CURRENT_EMP_ID.get();
    }

    public static void clear() {
        CURRENT_EMP_ID.remove();
    }
}
