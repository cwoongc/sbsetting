package com.cwoongc.sbsetting.api.user.entity;

import lombok.Data;

/**
 * User 예제 엔티티
 */
@Data
public class UserExampleEntity {

    /**
     * User 아이디
     */
    private Long id;

    /**
     * User 이름
     */
    private String name;

    /**
     * User 예제 코드
     */
    private String userExampleCd;

    public UserExampleEntity() {}

    public UserExampleEntity(long id) {
            this.id = id;
    }

    public UserExampleEntity(long id, String name, String userExampleCd) {
        this.id = id;
        this.name = name;
        this.userExampleCd = userExampleCd;
    }
}
