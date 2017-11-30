package com.cwoongc.sbsetting.api.user.service;

import com.cwoongc.sbsetting.api.user.exception.UserServiceException;
import com.cwoongc.sbsetting.api.user.mapper.UserMapper;
import com.cwoongc.sbsetting.api.user.message.UserServiceExceptionMessage;
import com.cwoongc.sbsetting.api.user.validate.UserServiceValidate;
import com.cwoongc.sbsetting.api.user.entity.UserExampleEntity;
import com.cwoongc.sbsetting.api.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserServiceImpl {


    @Autowired
    UserServiceValidate userServiceValidate;

    @Autowired
    UserMapper userMapper;

    /**
     * User 조회 서비스
     * @param id User 아이디
     * @return 조회대상
     */
    public UserVO getUser(Long id) {

        UserVO userVO;

        try {

            userServiceValidate.validateSelect(id);
            userVO = userMapper.selectUser(id);

        } catch (Exception ex) {
            UserServiceException threx = new UserServiceException(UserServiceExceptionMessage.USER_GET_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return userVO;

    }


    /**
     * User 등록 서비스
     *
     * @param userVO 등록대상 User
     * @return 등록된 User 수
     * @throws UserServiceException
     */
    public int insertUser(UserVO userVO) throws UserServiceException {

        int insertCnt = 0;

        try {

            UserExampleEntity userExampleEntity = userVO.convertUserExampleEntity();

            userServiceValidate.validateInsert(userExampleEntity);

            insertCnt += userMapper.insertUser(userExampleEntity);

        } catch (Exception ex) {
            UserServiceException threx = new UserServiceException(UserServiceExceptionMessage.USER_INSERT_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return insertCnt;
    }


    /**
     * User 수정 서비스
     *
     * @param userVO 수정대상 User
     * @return 수정된 User 수
     * @throws UserServiceException
     */
    public int updateUser(UserVO userVO) throws UserServiceException {

        int updateCnt = 0;

        try {

            UserExampleEntity userExampleEntity = userVO.convertUserExampleEntity();

            userServiceValidate.validateUpdate(userExampleEntity);

            updateCnt += userMapper.updateUser(userExampleEntity);

        } catch (Exception ex) {
            UserServiceException threx = new UserServiceException(UserServiceExceptionMessage.USER_UPDATE_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return updateCnt;
    }


    /**
     * User 삭제 서비스
     *
     * @param id User 아이디
     * @return 삭제된 User 수
     * @throws UserServiceException
     */
    public int deleteUser(Long id) throws UserServiceException {

        int deleteCnt = 0;

        try {

            userServiceValidate.validateDelete(id);
            deleteCnt += userMapper.deleteUser(id);

        } catch (Exception ex) {
            UserServiceException threx = new UserServiceException(UserServiceExceptionMessage.USER_DELETE_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return deleteCnt;

    }



}
