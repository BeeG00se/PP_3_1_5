package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;


@Component
public class RoleConverter implements Converter<String, Role> {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role convert(String source) {
        return roleRepository.findRoleByName(source);
    }
}
