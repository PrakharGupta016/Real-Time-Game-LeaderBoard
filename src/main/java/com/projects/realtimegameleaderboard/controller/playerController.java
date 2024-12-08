package com.projects.realtimegameleaderboard.controller;

import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import com.projects.realtimegameleaderboard.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Set;

@RestController
public class playerController {
    @Autowired
    private LeaderBoardService leaderBoardService;

    @PostMapping(value = "/send-score")
    ResponseEntity<PlayerInfo> sendScore(@RequestBody PlayerInfo playerInfo) throws InterruptedException {
        System.out.println(playerInfo.getPlayerId());
        leaderBoardService.setScore(playerInfo);
        return ResponseEntity.ok(playerInfo);
    }

    @GetMapping(value = "/get-leaderboard-asc")
    ResponseEntity<Set<Object>> getScore() {
        return ResponseEntity.ok(leaderBoardService.getLeaderboardAscending());
    }

    @GetMapping(value = "/get-leaderboard")
    ResponseEntity<Set<Object>> getLeaderBoard()
    {
        return ResponseEntity.ok(leaderBoardService.getLeaderboardDescending());
    }
}
