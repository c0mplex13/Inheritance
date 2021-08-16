package com.greg.inheritance;

public class NewService extends Request {

    private static int TOTAL_OF_SERVICES;

    public NewService(final String vendorName, final String accountName, final String serviceName) {
        super(vendorName, accountName, serviceName);

        ++TOTAL_OF_SERVICES;
    }

    public NewService(final String vendorName, final String accountName, final String serviceName,
                      RequestStatus requestStatus) {

        super(vendorName, accountName, serviceName, requestStatus);

        ++TOTAL_OF_SERVICES;
    }

    protected static int getTotalOfServices() {
        return TOTAL_OF_SERVICES;
    }

    @Override
    protected String getRequestType() {
        String requestType = "New Service";
        return requestType + " (from class: " + getClass().getSimpleName() + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " <> " + getRequestType();
    }


}
