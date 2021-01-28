package com.fall.tx;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xql132@zcsmart.com
 * @date 2021/1/28
 * @time 23:26
 * @description
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(String in, String out, double money) {
        accountDao.outMoney(out, money);

        accountDao.inMoney(in, money);
    }
}
