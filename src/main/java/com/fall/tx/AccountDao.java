package com.fall.tx;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/28
 * @time 23:26
 * @description
 */
public interface AccountDao {
    void outMoney(String out, double money);
    void inMoney(String in, double money);
}
