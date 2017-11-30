package com.cwoongc.sbsetting.api.user.controller;

import com.cwoongc.sbsetting.api.user.exception.UserControllerException;
import com.cwoongc.sbsetting.api.user.message.UserControllerExceptionMessage;
import com.cwoongc.sbsetting.api.user.service.UserServiceImpl;
import com.cwoongc.sbsetting.api.user.validate.UserControllerValidate;
import com.cwoongc.sbsetting.api.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value="/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserControllerValidate userControllerValidate;

    /**
     * User 조회 API
     *
     * @param id User 아이디
     * @return UserVO, http status code 200
     * @throws UserControllerException
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserVO> getUser(@PathVariable("id") Long id) {

        UserVO userVO;

        try {

            userControllerValidate.validateGet(id);

            userVO = userService.getUser(id);

        } catch (Exception ex) {
            UserControllerException threx = new UserControllerException(UserControllerExceptionMessage.USER_GET_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        ResponseEntity<UserVO> re;

        if(userVO == null)
            re = new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
        else
            re = new ResponseEntity<UserVO>(userVO, HttpStatus.OK);

        return re;
    }



    /**
     * User 등록 API
     * @param userVO 등록할 User
     * @return http status code 200
     * @throws UserControllerException
     */
    @PostMapping("")
    public ResponseEntity registerUser(@RequestBody UserVO userVO) throws UserControllerException {

        try {

            userControllerValidate.validateRegister(userVO);

            userService.insertUser(userVO);

        } catch (Exception ex) {
            UserControllerException threx = new UserControllerException(UserControllerExceptionMessage.USER_REGISTER_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /**
     * User 수정 API
     *
     * @param userVO 수정할 User
     * @return Status code 200
     * @throws UserControllerException
     */
    @PutMapping("")
    public ResponseEntity updateUser(@RequestBody UserVO userVO) throws UserControllerException {
        try {

            userControllerValidate.validateUpdate(userVO);

            userService.updateUser(userVO);

        } catch (Exception ex) {
            UserControllerException threx = new UserControllerException(UserControllerExceptionMessage.USER_UPDATE_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * User 삭제 API
     *
     * @param id 삭제대상 User 아이디
     * @return Status code 200
     * @throws UserControllerException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) throws UserControllerException {
        try {

            userControllerValidate.validateDelete(id);

            userService.deleteUser(id);

        } catch (Exception ex) {
            UserControllerException threx = new UserControllerException(UserControllerExceptionMessage.USER_DELETE_ERROR, ex);
            if (log.isErrorEnabled()) {
                log.error(threx.getMessage(), threx);
            }
            throw threx;
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}


