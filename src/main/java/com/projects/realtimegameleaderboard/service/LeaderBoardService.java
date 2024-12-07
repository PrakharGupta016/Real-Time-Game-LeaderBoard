package com.projects.realtimegameleaderboard.service;

import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardService {

    @Autowired
    private RedisTemplate<String,Integer> redisTemplate;

    public void setScore(PlayerInfo playerInfo)
    {
        String playerId = String.valueOf(playerInfo.getPlayerId());
        redisTemplate.opsForValue().set(playerId, playerInfo.getPlayerScore());
    }

    public Integer getValue(String key) {
        Integer score = redisTemplate.opsForValue().get(key);
        return score != null ? score : 0;
    }
}
