package com.projects.realtimegameleaderboard.service;

import com.projects.realtimegameleaderboard.dto.PlayerData;
import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeaderBoardService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setScore(PlayerInfo playerInfo) {
        redisTemplate.opsForZSet().add("gameLeaderBoard", playerInfo.getPlayerId(), playerInfo.getPlayerScore());
    }

    public Set<Object> getLeaderboardAscending() {
        return Collections.singleton(redisTemplate.opsForZSet().rangeWithScores("gameLeaderBoard", 0, -1));
    }

    public Set<Object> getLeaderboardDescending()
    {
        return Collections.singleton(redisTemplate.opsForZSet().reverseRangeWithScores("gameLeaderBoard", 0, -1));
    }
}
