package com.example.banking.Domain;

public class TransactionDomain {

       private String tv_trans_amount, tv_trans_refNo,ic_trans_status,tv_trans_name;

    public String getTv_trans_amount() {
        return tv_trans_amount;
    }

    public void setTv_trans_amount(String tv_trans_amount) {
        this.tv_trans_amount = tv_trans_amount;
    }

    public String getTv_trans_refNo() {
        return tv_trans_refNo;
    }

    public void setTv_trans_refNo(String tv_trans_refNo) {
        this.tv_trans_refNo = tv_trans_refNo;
    }

    public String getIc_trans_status() {
        return ic_trans_status;
    }

    public void setIc_trans_status(String ic_trans_status) {
        this.ic_trans_status = ic_trans_status;
    }

    public String getTv_trans_name() {
        return tv_trans_name;
    }

    public void setTv_trans_name(String tv_trans_name) {
        this.tv_trans_name = tv_trans_name;
    }

    public TransactionDomain(String tv_trans_amount, String tv_trans_refNo, String ic_trans_status, String tv_trans_name) {
        this.tv_trans_amount = tv_trans_amount;
        this.tv_trans_refNo = tv_trans_refNo;
        this.ic_trans_status = ic_trans_status;
        this.tv_trans_name = tv_trans_name;
    }
}
