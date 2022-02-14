package com.heights.auditapp.model;

public enum AUDIT_TYPE {
    ROUTINE(1),
    ADHOC(2),
    SPOT_CHECK(3),
    FOLLOW_UP(4),
    SPECIAL_INVESTIGATION(5);

    private final int id;

    AUDIT_TYPE(int numVal){
        this.id = numVal;
    }

    public static String getEnumByString(int id){
        for(AUDIT_TYPE e : AUDIT_TYPE.values()){
            if(e.getId() == id) return e.name();
        }
        return null;
    }

    public int getId(){
        return id;
    }
}
