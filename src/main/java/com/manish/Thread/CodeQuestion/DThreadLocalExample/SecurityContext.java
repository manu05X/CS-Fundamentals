package com.manish.Thread.CodeQuestion.DThreadLocalExample;

public class SecurityContext {
    // ThreadLocal to store the SecurityContext for each thread
    private static final ThreadLocal<SecurityContext> threadLocalContext = ThreadLocal.withInitial(SecurityContext::new);

    private String userId;
    private String[] roles;

    // Private constructor to prevent instantiation from outside
    SecurityContext() { }

    // Get the current thread's security context
    public static SecurityContext getContext() {
        return threadLocalContext.get();
    }

    // Set the security context for the current thread
    public static void setContext(SecurityContext context) {
        threadLocalContext.set(context);
    }

    // Clear the security context for the current thread
    public static void clearContext() {
        threadLocalContext.remove();
    }

    // Getter and Setter for userId and roles
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}

