package com.tavisca.gce.tirctc.models.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.tavisca.gce.tirctc.models.booking.TicketBookingPerformerImpl;
import com.tavisca.gce.tirctc.models.entities.Booking;
import com.tavisca.gce.tirctc.models.entities.Passenger;
import org.aspectj.lang.JoinPoint;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFGeneratorService {

    public void generateTicketPdfOnSuccessfulBooking(JoinPoint jp)
    {
        TicketBookingPerformerImpl performer = (TicketBookingPerformerImpl) jp.getTarget();
        generateTicketPdf(performer.getBooking());
    }


    private void generateTicketPdf(Booking booking){
        Document document = new Document();
        try {
            String passengerDetails = "";
            for(Passenger passenger: booking.getPassengers()){
                passengerDetails += passenger.getName()+"      "+passenger.getAge()+"      "+passenger.getGender()+"      "+passenger.getSeatNumber()+"\n";
            }
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ticket_"+booking.getId()+".pdf"));
            document.open();
            document.add(new Paragraph("IRCTCS e-Ticketing Service\n" +
                    "Electronic Reservation Slip (Personal User)\n" +
                    "->This tick et will only be valid along with an ID proof in original. If found travelling without ID Proof,Passenger will " +
                    "be treated as wit hout ticket and charged as per extant Railwa y rules.\n" +
                    "->Valid IDs to be presented during train journey by one of the passenger booked on an e-ticket :- Voter Identity " +
                    "Card / Passport / PAN Card / Driving License / Photo ID card issued by Central/ State Govt./ Student Identity " +
                    "Card with photograph issued by recognized School or Colle ge for their students / Nationalized Bank Passbook with " +
                    "photograph / Credit Cards issued by Bank s with laminated photograph / Unique Identification Card \"Aadhaar\".\n" +
                    "->General rules / Information for e-ticket passenger have to be studied by the customer for cancellation & refund.\n\n\n" +
                    "Booking Details\n"+
                    "PNR no: "+booking.getId()+
                    "\n Train No.: "+booking.getTrainId()+
                    "\n Train Name.: "+booking.getTrainName()+
                    "\n Journey Date: "+booking.getJourneyDate()+
                    "\n Source: "+booking.getSource()+
                    "\n Destination: "+booking.getDestination()+
                    "\n\nPassenger Details\n"+passengerDetails+"\n\n" +
                    "This ticket is booke d on a personal user ID and cannot be sold by an a gent. If bought from an agent by any individual, it is at " +
                    "his/her own risk.\n" +
                    "IMPORTANT:\n" +
                    "->For details, rules and terms & conditions of E-Tick eting services, please visit www.irctc.co.in.\n" +
                    "->*New Time Table is effective from 01-07-2012. Departure time and Arrival Time printed on this ERS/VRM is liable " +
                    "to change. Plea se Che ck correct departure, arrival from Railway Station Enquiry, Dial 139 or SMS RAIL to 139.\n" +
                    "->The accommodation booked is not transferable and is valid only if one of the ID card noted above is pre sented " +
                    "during the journey. The ERS/VRM/SMS sent by IRCTC along with the valid ID proof in original would be verified by " +
                    "TTE with the name and PNR on the chart. If the passenger fail to produce/display ERS/VRM/SMS sent by IRCTC " +
                    "due to any eventua lity (loss, damaged mo bile /laptop etc.) but has the prescribed original proof of identity, a " +
                    "pena ity of Rs.50/- per ticket as applica ble to such cases will be levied. The ticket checking staff On board/Off " +
                    "board will give Excess Fare Ticket for the same.\n" +
                    "-> E-ticket cancellations are permitted through www.irctc.co.in by the user.\n" +
                    "-> Obta in certificate from the TTE /Conductor in case of PARTIA LLY waitlisted e-ticket, LESS NO. OF PASSENGERS " +
                    "travelled, A.C.FAILURE, TRAVEL IN LOWER CLASS. This original certificate must be sent to GGM (IT), IRCTC Ltd., " +
                    "Internet Ticketing Centre, IRCA Building, State Entry Road, New Delhi-110055 after filing on-line refund request " +
                    "for claiming refund.\n" +
                    "-> Contact us on: - 24*7 Hrs Customer Support at 011-39340000, Chennai Customer Care 044 ác\" 25300000 or Mail " +
                    "To: care@irctc.co.in."));
            document.addAuthor("Fargi-IRCTC");
            document.addCreationDate();
            document.addCreator("FargiIRCTC.com");
            document.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

