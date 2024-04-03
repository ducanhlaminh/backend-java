package com.example.foooball_app.service;
import java.util.List;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
@Service
public class TeamService {
    @Autowired
    private TeamRepository TeamRepository;

    private static final Logger logger = Logger.getLogger(TeamService.class.getName());

    public Team createTeamService(TeamRequest req) {
        Team team = new Team();
        team.setTeamName(req.getTeamName());
        team.setCountry(req.getCountry());


        if(TeamRepository.existsByTeamName(team.getTeamName())) {
            throw new AppError(ErrorCode.USER_EXISTED);
        }
        return TeamRepository.save(team);
    }
    public List<Team> getAll() {
        return TeamRepository.findAll();
    }
}
