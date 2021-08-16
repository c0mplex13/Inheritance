package com.greg.inheritance;

import java.util.Scanner;

public enum RequestStatus {
    UNASSIGNED("Waiting for assignation", 0),
    CREATED("Request was just created", 1),
    IN_PROGRESS("Request is being processed", 2),
    CLOSED("Request is closed", 3);

    private final String description;
    private final int ordinalNumber;

    private boolean isStatusValid(String status) {
        return status.equals("1") || status.equals("2") || status.equals("3");

    }

    RequestStatus(final String description, final int orderNumber) {
        this.description = description;
        this.ordinalNumber = orderNumber;
    }

    public int showOrdinalNumber() {
        return ordinalNumber;
    }

    protected RequestStatus setRequestStatusEnum() {

        RequestStatus[] possibleStatuses = RequestStatus.values();
        System.out.print("Provide request status. Choose: ");

        for (RequestStatus chosenStatus : possibleStatuses) {
            if (chosenStatus.showOrdinalNumber() != 0) {
                System.out.print(chosenStatus + " - " + chosenStatus.showOrdinalNumber() + "  ");
            }
        }

        Scanner scanner = new Scanner(System.in);
        String chosenStatusAsOrdinalNumber;

        do {
            System.out.print("\nType-in number between 1 - 3: ");
            chosenStatusAsOrdinalNumber = scanner.nextLine();
        } while (!isStatusValid(chosenStatusAsOrdinalNumber));

        switch (chosenStatusAsOrdinalNumber) {
            case "1":
                return RequestStatus.CREATED;
            case "2":
                return RequestStatus.IN_PROGRESS;
            case "3":
                return RequestStatus.CLOSED;
            default:
                return RequestStatus.UNASSIGNED;
        }
    }

    @Override
    public String toString() {
        return "*" + description + "*";
    }

}
