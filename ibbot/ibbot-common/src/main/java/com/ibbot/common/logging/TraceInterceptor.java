package com.ibbot.common.logging;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

public class TraceInterceptor extends CustomizableTraceInterceptor 
{
	protected Logger logger = LoggerFactory.getLogger(TraceInterceptor.class);

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) 
	{
		if (ex != null) 
		{
			logger.info(message, ex);
		} 
		else 
		{
			logger.info(message);
		}
	}

	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) 
	{
		return true;
	}

	private static final long serialVersionUID = 287162721460370957L;
}