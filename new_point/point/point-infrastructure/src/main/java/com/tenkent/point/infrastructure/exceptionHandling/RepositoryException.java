package com.tenkent.point.infrastructure.exceptionHandling;

import com.tenkent.point.infrastructure.utility.StringUtility;

/**
 * Created by 6418000384 on 2016/7/15.
 */
public class RepositoryException extends BaseException {
    private static String errmessage = "数据库处理错误";

    public RepositoryException() {
        super();
        this.setDetailMessage(errmessage);
    }

    public RepositoryException(String message) {
        super(message);
        this.setDetailMessage(errmessage);
    }

    public RepositoryException(String messageTemplate, Object... params) {
        super(StringUtility.format(messageTemplate, params));
        this.setDetailMessage(errmessage);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
        this.setDetailMessage(errmessage);
    }

    public RepositoryException(Throwable cause, String messageTemplate, Object... params) {
        super(StringUtility.format(messageTemplate, params), cause);
        this.setDetailMessage(errmessage);

    }
}
