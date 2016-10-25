package org.seckill.personal.enums;

public enum SeckillStateEnum
{
    SUCCESS(1, "秒杀成功"), END(0, "秒杀结束"), REPAET_KILL(-1, "重复秒杀"), INNER_ERROR(-2, "内部异常"), DATA_REWRITE(-3, "数据篡改");
    
    private int state;
    
    private String stateInfo;
    
    private SeckillStateEnum(int state, String stateInfo)
    {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    
    public static SeckillStateEnum statsseOf(int index)
    {
        for (SeckillStateEnum state : values())
        {
            if (state.getState() == index)
            {
                return state;
            }
        }
        return null;
    }
    
    public int getState()
    {
        return state;
    }
    
    public String getStateInfo()
    {
        return stateInfo;
    }
}
