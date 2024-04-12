package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Tournament;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
}
