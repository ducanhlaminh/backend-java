package com.example.foooball_app;
import java.util.List;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository TeamRepository;
    public Team createReq(TeamRequest req) {
        Team team = new Team();
        team.setTeam(req.getTeam_name());
        return TeamRepository.save(team);
    }
    public List<Team> getAll() {
        return TeamRepository.findAll();
    }
}
