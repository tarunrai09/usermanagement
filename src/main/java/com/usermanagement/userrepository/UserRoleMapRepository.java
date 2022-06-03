package com.usermanagement.userrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.rolemodel.UserRoleMap;


@Repository
public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, Integer>{

	List<Integer> findByUserId(String userId);
}

