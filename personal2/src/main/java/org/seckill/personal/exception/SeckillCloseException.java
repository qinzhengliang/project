package org.seckill.personal.exception;

public class SeckillCloseException extends SeckillException
{

    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;

    public SeckillCloseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SeckillCloseException(String message)
    {
        super(message);
    }
    
    
    
}
