package com.projects.realtimegameleaderboard.service;

import com.projects.realtimegameleaderboard.dto.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardService {

    @Autowired
    private RedisTemplate<Integer,Integer> redisTemplate;
    public void setScore(PlayerInfo playerInfo)
    {
        redisTemplate.opsForValue().set(playerInfo.getPlayerId(),playerInfo.getPlayerScore());
    }

}
