package com.cwoongc.sbsetting.api.user.code;


/**
 * PD999 예제코드
 * USER_EXAMPLE.USER_EXAMPLE_CD
 */
public enum UserExampleCd {

    USER_CODE_A("01","코드A값"),
    USER_CODE_B("02","코드B값")
    ;


    public final String groupCode = "PD999";
    public final String groupCodeName = "예제코드";
    public final String code;
    public final String codeName;


    UserExampleCd(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }



}
