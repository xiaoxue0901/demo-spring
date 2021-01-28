package com.fall.tx;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/28
 * @time 23:25
 * @description
 */
public interface AccountService {

    void transfer(String in, String out, double money);
}
