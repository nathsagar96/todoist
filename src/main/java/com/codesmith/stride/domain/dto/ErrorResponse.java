package com.codesmith.stride.domain.dto;

public record ErrorResponse(int status, String message, String details) {}
