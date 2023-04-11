/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict.bean;

/**
 *
 * @author Administrator
 */
 
                
import java.io.Serializable;
//import CalculateHelper;

public class CalculateBean implements Serializable {

    private int value1;
    private int value2;
    private String operator;

    public CalculateBean() {
    }

    public int getValue1() {
	return value1;
    }

    public void setValue1(int v) {
	value1 = v;
    }

    public int getValue2() {
	return value2;
    }

    public void setValue2(int v) {
	value2 = v;
    }

    public String getOperator() {
	return operator;
    }

    public void setOperator(String o) {
	operator = o;
    }

 
}

