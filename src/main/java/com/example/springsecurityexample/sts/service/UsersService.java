package com.example.springsecurityexample.sts.service;

import com.example.springsecurityexample.sts.http.dto.UsersDTO;
import com.example.springsecurityexample.sts.repository.Users;
import com.example.springsecurityexample.sts.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Long save(UsersDTO vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = usersRepository.save(bean);
        return bean.getCodigoid();
    }

}
