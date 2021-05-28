package com.kks.example.user.service;

import com.kks.example.user.entity.UserRepository;
import com.kks.example.user.vo.UserRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public String save(UserRequestVO userRequestVO) {

        return userRepository.save(userRequestVO.toEntity()).getId();
    }
}
