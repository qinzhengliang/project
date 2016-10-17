package org.seckill.personal.dto;

import org.seckill.personal.entity.SuccessKilled;
import org.seckill.personal.enums.SeckillStateEnum;

public class SeckillExecution
{
    private long seckill;
    
    private int state;
    
    private String stateInfo;
    
    private SuccessKilled successKilled;
    
    public SeckillExecution(long seckill, SeckillStateEnum stateEnum, SuccessKilled successKilled)
    {
        this.seckill = seckill;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }
    
    public SeckillExecution(long seckill, SeckillStateEnum stateEnum)
    {
        this.seckill = seckill;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    
    public long getSeckill()
    {
        return seckill;
    }
    
    public void setSeckill(long seckill)
    {
        this.seckill = seckill;
    }
    
    public int getState()
    {
        return state;
    }
    
    public void setState(int state)
    {
        this.state = state;
    }
    
    public String getStateInfo()
    {
        return stateInfo;
    }
    
    public void setStateInfo(String stateInfo)
    {
        this.stateInfo = stateInfo;
    }
    
    public SuccessKilled getSuccessKilled()
    {
        return successKilled;
    }
    
    public void setSuccessKilled(SuccessKilled successKilled)
    {
        this.successKilled = successKilled;
    }
    
    @Override
    public String toString()
    {
        return "SeckillExecution [seckill=" + seckill + ", state=" + state + ", stateInfo=" + stateInfo
            + ", successKilled=" + successKilled + "]";
    }
}
