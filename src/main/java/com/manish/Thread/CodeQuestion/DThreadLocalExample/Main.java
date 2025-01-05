package com.manish.Thread.CodeQuestion.DThreadLocalExample;

public class Main {
    public static void main(String[] args) {
        // Set up the security context for the current thread
        SecurityContext securityContext = new SecurityContext();
        securityContext.setUserId("user123");
        securityContext.setRoles(new String[]{"ROLE_USER", "ROLE_ADMIN"});

        // Set the context to the current thread
        SecurityContext.setContext(securityContext);

        // Later in the application, retrieve the security context
        SecurityContext context = SecurityContext.getContext();
        System.out.println("User ID: " + context.getUserId());
        System.out.println("Roles: " + String.join(",", context.getRoles()));

        // Clean up the security context
        SecurityContext.clearContext();
    }
}
