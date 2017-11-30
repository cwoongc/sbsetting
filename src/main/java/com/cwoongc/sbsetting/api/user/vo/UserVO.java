package com.cwoongc.sbsetting.api.user.vo;

import lombok.Data;
import com.cwoongc.sbsetting.api.user.entity.UserExampleEntity;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -1L;

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

    public UserExampleEntity convertUserExampleEntity() {
        return new UserExampleEntity(
                this.id,
                this.name,
                this.userExampleCd
        );
    }

}
