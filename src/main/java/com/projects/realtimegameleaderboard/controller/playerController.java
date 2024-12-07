package com.projects.realtimegameleaderboard.controller;

import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import com.projects.realtimegameleaderboard.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class playerController {
    @Autowired
    private LeaderBoardService leaderBoardService;
    @PostMapping(value = "/send-score")
    PlayerInfo sendScore(@RequestBody PlayerInfo playerInfo) throws InterruptedException {
        System.out.println(playerInfo.getPlayerId());
        leaderBoardService.setScore(playerInfo);
        return playerInfo;
    }
}
