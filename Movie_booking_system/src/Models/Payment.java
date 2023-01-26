package Models;

import Enums.PaymentStatus;

public class Payment {
    int paymentid;
    PaymentStatus paymentstatus;

    public Payment(int paymentid, PaymentStatus paymentstatus) {
        this.paymentid = paymentid;
        this.paymentstatus = paymentstatus;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public PaymentStatus getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(PaymentStatus paymentstatus) {
        this.paymentstatus = paymentstatus;
    }
}
