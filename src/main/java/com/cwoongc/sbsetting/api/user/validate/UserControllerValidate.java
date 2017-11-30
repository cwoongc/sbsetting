package com.cwoongc.sbsetting.api.user.validate;

import com.cwoongc.sbsetting.api.user.code.UserExampleCd;
import com.cwoongc.sbsetting.api.user.vo.UserVO;
import com.cwoongc.sbsetting.api.user.exception.UserControllerValidateException;
import com.cwoongc.sbsetting.api.user.message.UserControllerValidateExceptionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserControllerValidate {

    public void validateGet(Long id) {
        isIdEmpty(id);
    }

    public void validateRegister(UserVO userVO) {
        isIdEmpty(userVO.getId());
        isNameEmpty(userVO.getName());
        isUserExampleCdEmpty(userVO.getUserExampleCd());
        isUserExampleCdInvalid(userVO.getUserExampleCd());

    }

    public void validateUpdate(UserVO userVO) {
        isIdEmpty(userVO.getId());
        isNameEmpty(userVO.getName());
        isUserExampleCdEmpty(userVO.getUserExampleCd());
        isUserExampleCdInvalid(userVO.getUserExampleCd());
    }

    public void validateDelete(Long id) {
        isIdEmpty(id);
    }

    public void isIdEmpty(Long id) {
        if(id == null)
            throwException(UserControllerValidateExceptionMessage.USER_ID_IS_EMPTY);
    }

    public void isNameEmpty(String name) {
        if(name == null || name.isEmpty())
            throwException(UserControllerValidateExceptionMessage.USER_NAME_IS_EMPTY);
    }

    public void isUserExampleCdEmpty(String userExampleCd) {
        if(userExampleCd == null || userExampleCd.isEmpty())
            throwException(UserControllerValidateExceptionMessage.USER_EXAMPLE_CD_IS_EMPTY);
    }

    public void isUserExampleCdInvalid(String code) {

        if(code != null && !code.isEmpty()) {

            boolean exists = false;

            for(UserExampleCd userExampleCd : UserExampleCd.values()) {
                if(userExampleCd.code.equals(code)) {
                    exists = true;
                    break;
                }
            }

            if(!exists)
                throwException(UserControllerValidateExceptionMessage.USER_EXAMPLE_CD_IS_INVALID);
        }
    }

    private void throwException(String message) {
        UserControllerValidateException threx = new UserControllerValidateException(message);
        if(log.isErrorEnabled()) {
            log.error(threx.getMessage(), threx);
        }
        throw threx;
    }



}
