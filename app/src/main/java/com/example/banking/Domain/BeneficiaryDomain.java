package com.example.banking.Domain;

public class BeneficiaryDomain {
    private String name , AcNo,BankName;

    public BeneficiaryDomain(String name, String acNo, String bankName) {
        this.name = name;
        AcNo = acNo;
        BankName = bankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcNo() {
        return AcNo;
    }

    public void setAcNo(String acNo) {
        AcNo = acNo;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}
