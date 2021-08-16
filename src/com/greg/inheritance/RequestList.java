package com.greg.inheritance;

import java.util.ArrayList;

public final class RequestList extends ArrayList<Request> {
    private static final long serialVersionUID = 1L;
    protected static final RequestList INSTANCE = new RequestList();

    private RequestList() {
    }
}
