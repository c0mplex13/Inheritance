package com.greg.inheritance;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.execute();

    }

    void execute() {
        dataInputAndAddToList();

        serviceCheckForUnassigned();

        System.out.println("New services: " + NewService.getTotalOfServices());
        System.out.println("Terminations: " + Termination.getTotalOfServices());
        System.out.println("All services: " + Request.getTotalOfServices());

        showRequestDetails();
        showAllRequests();

    }

    private void dataInputAndAddToList() {

        RequestList.INSTANCE.add(new NewService("SiX", "3442523", "SiX Indices"));
        RequestList.INSTANCE
                .add(new NewService("Bloomberg", "123EED", "Bloomberg Terminal", RequestStatus.valueOf("CREATED")));
        RequestList.INSTANCE.add(
                new NewService("Refinitiv", "0092336623", "Refinitiv Global License", RequestStatus.valueOf("CLOSED")));
        RequestList.INSTANCE.add(new NewService("TSE", "I1233RFD", "TSE Indices Japan"));
        RequestList.INSTANCE.add(new Termination("Bloomberg", "XX4490433", "Real Time Index 40"));

    }

    private void serviceCheckForUnassigned() {
        for (Request request : RequestList.INSTANCE) {
            request.checkAndSetRequestStatusForUnassigned();
        }
    }

    private void showRequestDetails() {
        for (Request request : RequestList.INSTANCE) {
            request.showRequestDetails();
        }
    }

    public void showAllRequests() {
        System.out.println("Listing of all requests:");
        System.out.println("Vendor Name # Account Name # Service Name <> Service Type");
        RequestList.INSTANCE.forEach(System.out::println);
    }

}
