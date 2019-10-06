package com.loukaiwei;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("仓库")
@Scope(scopeName = "singleton")
public interface UserRepository extends CrudRepository<User, Long> {
}
