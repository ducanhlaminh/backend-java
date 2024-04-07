package com.example.foooball_app.service;

import com.example.foooball_app.entity.Match;
import com.example.foooball_app.repository.MatchRepository;
import com.example.foooball_app.request.MatchCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match createMatchService(MatchCreateRequest req){
        Match match = new Match();
        match.setMatchDate(req.getMatchDate());
        match.setStadium(req.getStadium());
        match.setResult(req.getResult());

        return matchRepository.save(match);
    }
}
