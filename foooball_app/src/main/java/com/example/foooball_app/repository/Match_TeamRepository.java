package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Match_Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Match_TeamRepository extends JpaRepository<Match_Teams,Integer> {
}
