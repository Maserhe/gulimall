package com.jpg6.gulimall.member.execption;


public class UsernameException extends RuntimeException {


    public UsernameException() {
        super("存在相同的用户名");
    }
}
