package co.grandcircus.capstone6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.capstone6.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
