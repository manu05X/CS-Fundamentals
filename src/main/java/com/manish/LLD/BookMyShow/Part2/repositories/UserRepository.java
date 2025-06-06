package com.manish.LLD.BookMyShow.Part2.repositories;

import com.manish.LLD.BookMyShow.Part2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);

    User save(User user);
}
