package com.cwoongc.sbsetting.api.user.validate;

import com.cwoongc.sbsetting.api.user.entity.UserExampleEntity; //Fixme
import com.cwoongc.sbsetting.api.user.code.UserExampleCd; //Fixme
import com.cwoongc.sbsetting.api.user.exception.UserServiceValidateException;
import com.cwoongc.sbsetting.api.user.message.UserServiceValidateExceptionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserServiceValidate {

    public void validateSelect(Long id) {
            isIdEmpty(id);
    }

    public void validateInsert(UserExampleEntity userExampleEntity) {
        isIdEmpty(userExampleEntity.getId());
        isNameEmpty(userExampleEntity.getName());
        isUserExampleCdEmpty(userExampleEntity.getUserExampleCd());
        isUserExampleCdInvalid(userExampleEntity.getUserExampleCd());
    }

    public void validateUpdate(UserExampleEntity userExampleEntity) {
        isIdEmpty(userExampleEntity.getId());
        isNameEmpty(userExampleEntity.getName());
        isUserExampleCdEmpty(userExampleEntity.getUserExampleCd());
        isUserExampleCdInvalid(userExampleEntity.getUserExampleCd());
    }

    public void validateDelete(Long id) {
        isIdEmpty(id);
    }

    public void isIdEmpty(Long id) {
        if(id == null)
            throwException(UserServiceValidateExceptionMessage.USER_ID_IS_EMPTY);
    }

    public void isNameEmpty(String name) {
        if(name == null || name.isEmpty())
            throwException(UserServiceValidateExceptionMessage.USER_NAME_IS_EMPTY);
    }

    private void isUserExampleCdEmpty(String USERExampleCd) {
        if(USERExampleCd == null || USERExampleCd.isEmpty())
            throwException(UserServiceValidateExceptionMessage.USER_EXAMPLE_CD_IS_EMPTY);

    }

    public void isUserExampleCdInvalid(String code) {

        if(code != null || !code.isEmpty()) {

            boolean exists = false;

            for(UserExampleCd userExampleCd : UserExampleCd.values()) {
                if(userExampleCd.code.equals(code)) {
                    exists = true;
                    break;
                }
            }

            if(!exists)
                throwException(UserServiceValidateExceptionMessage.USER_EXAMPLE_CD_IS_INVALID);
        }
    }


    private void throwException(String message) {
        UserServiceValidateException threx = new UserServiceValidateException(message);
        if(log.isErrorEnabled()) {
            log.error(threx.getMessage(), threx);
        }
        throw threx;
    }



}
