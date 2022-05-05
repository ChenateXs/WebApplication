package it.engineering.web.WebApp.spring.repository;

import it.engineering.web.WebApp.entity.UserEntity;

public interface UserRepository {

	UserEntity login(UserEntity userEntity);
}
