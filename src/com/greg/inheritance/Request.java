package com.greg.inheritance;

public abstract class Request {

    private static int TOTAL_OF_SERVICES;

    private final String vendorName;
    private final String accountName;
    private final String serviceName;
    protected RequestStatus requestStatus = RequestStatus.UNASSIGNED;

    protected void checkAndSetRequestStatusForUnassigned() {
        if (this.requestStatus.equals(RequestStatus.UNASSIGNED)) {
            this.requestStatus = requestStatus.setRequestStatusEnum();
        }
    }

    protected void showRequestDetails() {
        System.out.println("------------DETAILED INFO-----FOR " + getClass().getSimpleName() + "----");
        System.out.print("Vendor Name: " + getVendorName() + "  **  ");
        System.out.print("Account Name: " + getAccountName() + "  **  ");
        System.out.print("Service Name: " + getServiceName() + "  **  ");
        System.out.println("Request Status: " + getRequestStatus().name() + " (" + (getRequestStatus()) + ")");
        System.out.println("----------------------------------------");
    }

    public Request(final String vendorName, final String accountName, final String serviceName) {
        this.vendorName = vendorName;
        this.accountName = accountName;
        this.serviceName = serviceName;

        ++TOTAL_OF_SERVICES;
    }

    public Request(final String vendorName, final String accountName, final String serviceName,
                   RequestStatus requestStatus) {
        this(vendorName, accountName, serviceName);
        this.requestStatus = requestStatus;
    }

    protected String getRequestType() {
        return "Service Template";
    }

    protected String getVendorName() {
        return vendorName;
    }

    protected String getAccountName() {
        return accountName;
    }

    protected String getServiceName() {
        return serviceName;
    }

    protected RequestStatus getRequestStatus() {
        return requestStatus;
    }

    protected static int getTotalOfServices() {
        return TOTAL_OF_SERVICES;
    }

    @Override
    public String toString() {
        return vendorName + " # " + accountName + " # " + serviceName;
    }

}
