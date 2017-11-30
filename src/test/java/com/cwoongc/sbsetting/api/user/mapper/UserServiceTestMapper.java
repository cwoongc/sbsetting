package com.cwoongc.sbsetting.api.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.cwoongc.sbsetting.api.user.vo.UserVO;
import com.cwoongc.sbsetting.api.user.entity.UserExampleEntity;

@Mapper
public interface UserServiceTestMapper {

    /**
     * User 조회 by PK
     * @param id User 아이디
     * @return 조회된 User
     */
    UserVO selectUser(@Param("id") long id);

    /**
    * User 등록
    * @param userExampleEntity User
    * @return 등록된 User 수
    */
    int insertUser(UserExampleEntity userExampleEntity);

    /**
     * User 수정
     * @param userExampleEntity User
     * @return 수정된 User 수
     */
    int updateUser(UserExampleEntity userExampleEntity);

    /**
     * User 삭제
     * @param id User 아이디
     * @return 삭제된 User 수
     */
    int deleteUser(@Param("id") long id);

}
