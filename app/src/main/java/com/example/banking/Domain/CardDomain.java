package com.example.banking.Domain;

public class CardDomain {

    private String cardname;
    private String cardno;
    private String cardimg;
    private String carddate;
    private int drawableResourceId;

    public int getDrawableResourceId() {
        return drawableResourceId;
    }

    public void setDrawableResourceId(int drawableResourceId) {
        this.drawableResourceId = drawableResourceId;
    }

    public CardDomain(String cardname, String cardno, String cardimg, String carddate, int drawableResourceId) {
        this.cardname = cardname;
        this.cardno = cardno;
        this.cardimg = cardimg;
        this.carddate = carddate;
        this.drawableResourceId = drawableResourceId;
    }



    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg;
    }

    public String getCarddate() {
        return carddate;
    }

    public void setCarddate(String carddate) {
        this.carddate = carddate;
    }
}
