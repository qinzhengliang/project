package org.seckill.personal.exception;

public class SeckillException extends RuntimeException
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;

    public SeckillException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SeckillException(String message)
    {
        super(message);
    }
    
    
    
}
