package org.seckill.personal.exception;

public class RepeatSeckillException extends SeckillException
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;

    public RepeatSeckillException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RepeatSeckillException(String message)
    {
        super(message);
    }
    
    
    
}
