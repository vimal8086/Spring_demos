package com.phoenix.repositories;
/*
 * @Author vimal.makwana@stltech.in
 * @version 1.0
 * @creatondate 2-aug-2021
 * @copyright sterlite technology ltd..
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.User;

public interface UserRepository extends JpaRepository<User,String>{

}
