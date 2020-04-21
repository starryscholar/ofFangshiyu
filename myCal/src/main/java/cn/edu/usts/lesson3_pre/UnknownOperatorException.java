package cn.edu.usts.lesson3_pre;

/**
 * Created by 11616 on 2020/3/7.
 */

public class UnknownOperatorException extends Exception{
    private static final long serialVersionUID = 1L;

    public UnknownOperatorException(char operator) {
        super(String.format("'%c' is not a valid operator.", operator));
    }
}
