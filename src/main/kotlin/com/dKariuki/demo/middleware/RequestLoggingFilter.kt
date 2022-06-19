package com.dKariuki.demo.middleware

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
class RequestLoggingFilter : Filter {
    val loggerFactory: Logger = LoggerFactory.getLogger("NFT Logger")

    override fun doFilter(
        servletRequest: ServletRequest,
        servletResponse: ServletResponse,
        filterChain: FilterChain
    ) {
        val utmSource = servletRequest.getParameter("utm_source")
        loggerFactory.info("Logging UTM source: $utmSource")
        filterChain.doFilter(servletRequest, servletResponse)
    }
}