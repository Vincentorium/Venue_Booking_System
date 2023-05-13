package com.itp4511.servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TotalPriceTag extends TagSupport {

    private int session;
    private int price;

    public void setSession(int session) {
        this.session = session;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            // count the total price
            int totalPrice = session * price;

            // put total price to JSP page
            JspWriter out = pageContext.getOut();
            out.print(totalPrice);
        } catch (Exception e) {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }
}