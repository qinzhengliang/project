package org.seckill.personal.entity;

import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  qzl
 * @version  [版本号, 2016年10月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SuccessKilled
{
    private long seckillId;
    
    private long userPhone;
    
    private short state;
    
    private Date createTime;
    
    private Seckill seckill;
    
    public Seckill getSeckill()
    {
        return seckill;
    }
    
    public void setSeckill(Seckill seckill)
    {
        this.seckill = seckill;
    }
    
    public long getSeckillId()
    {
        return seckillId;
    }
    
    public void setSeckillId(long seckillId)
    {
        this.seckillId = seckillId;
    }
    
    public long getUserPhone()
    {
        return userPhone;
    }
    
    public void setUserPhone(long userPhone)
    {
        this.userPhone = userPhone;
    }
    
    public short getState()
    {
        return state;
    }
    
    public void setState(short state)
    {
        this.state = state;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    @Override
    public String toString()
    {
        return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
            + ", createTime=" + createTime + ", seckill=" + seckill + "]";
    }
    
}
