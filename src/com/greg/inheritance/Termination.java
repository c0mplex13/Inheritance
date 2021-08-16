package com.greg.inheritance;

public class Termination extends Request {

    private static int TOTAL_OF_SERVICES;

    public Termination(final String vendorName, final String accountName, final String serviceName) {
        super(vendorName, accountName, serviceName);

        ++TOTAL_OF_SERVICES;
    }

    public static int getTotalOfServices() {
        return TOTAL_OF_SERVICES;
    }

    @Override
    protected String getRequestType() {
        String requestType = "Termination";
        return requestType + " (from class: " + getClass().getSimpleName() + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " <> " + getRequestType();
    }

}
