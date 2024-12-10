package com.projects.realtimegameleaderboard.service;

import com.projects.realtimegameleaderboard.dto.PlayerData;
import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeaderBoardService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SimpMessagingTemplate simpleMessageTemplate;

    public void setScore(PlayerInfo playerInfo) {
        redisTemplate.opsForZSet().add("gameLeaderBoard", playerInfo.getPlayerId(), playerInfo.getPlayerScore());
//        TODO use some msg queue do it async and buffer
        sendLeaderboardUpdateAsync();

    }

    public Set<Object> getLeaderboardAscending() {
        return Collections.singleton(redisTemplate.opsForZSet().rangeWithScores("gameLeaderBoard", 0, -1));
    }

    public Set<Object> getLeaderboardDescending() {
        Set<Object> data = Collections.singleton(redisTemplate.opsForZSet().reverseRangeWithScores("gameLeaderBoard", 0, -1));
        simpleMessageTemplate.convertAndSend("/topic/leaderboard", data);
        return data;
    }

    @Async
    void sendLeaderboardUpdateAsync() {
        Set<Object> data = Collections.singleton(redisTemplate.opsForZSet().reverseRangeWithScores("gameLeaderBoard", 0, -1));
        simpleMessageTemplate.convertAndSend("/topic/leaderboard", data);
        return;
    }
}
