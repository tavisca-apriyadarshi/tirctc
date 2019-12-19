package com.tavisca.gce.tirctc.models.booking;

import com.tavisca.gce.tirctc.models.dto.TicketInformationHolder;

public interface TicketBookingPerformer {
    void generateTicket(TicketInformationHolder ticketINformationHolder);
}
