package cn.edu.usts.lesson3_pre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //alt+enter import class    ctrl find extends class
    Button btnAdd,btnDec,btnDiv,btnMul,btnEqu,btnClear,btnDel;

    Button[] btn = new Button[11];
    int[] btnId = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btnDot};
    TextView txtResult;
    TextView txt;
    private boolean isChar = false;
    private  boolean isDot = false;

    private StringBuffer digitA = new StringBuffer(),digitB = new StringBuffer(),txtShow = new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.calc);

        initView();
        MyClick myClick = new MyClick();
        for(int i = 0;i<btn.length;i++){
            btn[i].setOnClickListener(myClick);

        }
        ComputeListener compute = new ComputeListener();
        btnAdd.setOnClickListener(compute);
        btnDec.setOnClickListener(compute);
        btnMul.setOnClickListener(compute);
        btnDiv.setOnClickListener(compute);
        btnClear.setOnClickListener(compute);
        btnDel.setOnClickListener(compute);
        btnEqu.setOnClickListener(compute);



    }
    void initView(){
        for(int i = 0;i<btn.length;i++){
            btn[i] = (Button) this.findViewById(btnId[i]);

        }
        txtResult = (TextView) this.findViewById(R.id.txtResult);
        txt = (TextView)this.findViewById(R.id.txt);
        btnAdd = (Button)this.findViewById(R.id.btnadd);
        btnEqu= (Button)this.findViewById(R.id.btnEqu);
        btnDec= (Button)this.findViewById(R.id.btndec);
        btnDiv= (Button)this.findViewById(R.id.btnDiv);
        btnMul = (Button)this.findViewById(R.id.btnMul);
        btnDel= (Button)this.findViewById(R.id.btnDel);
        btnClear= (Button)this.findViewById(R.id.btnC);


    }
    //定义一个单击方法
    public void myOnclick(View v){
        Log.i("info","单击事件发生了");
    }
    class MyClick implements View.OnClickListener{  //alt + insert 继承父类方法 ctrl + i implements methods

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn0:
                    setVal("0");
                    break;
                case R.id.btn1:
                    setVal("1");
                    break;
                case R.id.btn2:
                    setVal("2");
                    break;
                case R.id.btn3:
                    setVal("3");
                    break;
                case R.id.btn4:
                    setVal("4");
                    break;
                case R.id.btn5:
                    setVal("5");
                    break;
                case R.id.btn6:
                    setVal("6");
                    break;
                case R.id.btn7:
                    setVal("7");
                    break;
                case R.id.btn8:
                    setVal("8");
                    break;
                case R.id.btn9:
                    setVal("9");
                    break;
                case R.id.btnDot:
                    if(isDot==true){
                        return;
                    }
                    setVal(".");
                    isDot = true;
                    break;
            }

        }
    }
    public void setVal(String s) {


        txtShow.append(s);
        txt.setText(txtShow);
    }

    class ComputeListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            isDot = false;
            switch (v.getId()){
                case R.id.btnadd:

                    txtResult.setText("0");
                    txtShow.append("+");
                    txt.setText(txtShow);
                    break;
                case R.id.btndec:

                    txtResult.setText("0");
                    txtShow.append("-");
                    txt.setText(txtShow);
                    break;
                case R.id.btnMul:

                    txtResult.setText("0");
                    txtShow.append("×");
                    txt.setText(txtShow);
                    break;
                case R.id.btnDiv:

                    txtResult.setText("0");
                    txtShow.append("÷");
                    txt.setText(txtShow);
                    break;
                case R.id.btnC:
                    txtResult.setText("0");

                    txtShow = new StringBuffer();
                    txt.setText("");
                    break;
                case R.id.btnDel:
                    txtShow = txtShow.deleteCharAt(txtShow.length()-1);
                    txt.setText(txtShow);
                    break;
                case R.id.btnEqu:

                    double result = 0;
                    try {
                        result = operation(txtShow.toString());
                    } catch (UnknownOperatorException e) {
                        e.printStackTrace();
                    }
                    txtResult.setText(result+"");
                    digitA = new StringBuffer();
                    digitB = new StringBuffer();
                    isChar = false;
                    txtShow = new StringBuffer();
                    break;
            }
        }
    }




    private static String expressionCompletion(String expression){
        StringBuilder sb = new StringBuilder(expression);
        int len = sb.length();
        boolean b = false;
        for(int i=0;i<len;++i){
            char c = sb.charAt(i);
            b = false;

            if(c=='-' || c=='+'){
                if(i==0){
                    sb.insert(0, "(0");
                    b=true;
                }else{
                    if(RPN.isOperator(sb.charAt(i-1)) && sb.charAt(i-1)!=')'){
                        sb.insert(i, "(0");
                        b=true;
                    }
                }
                if(b){
                    len+=2;
                    for(int j=i+2;i<len;++j){
                        if(RPN.isOperator(sb.charAt(j))){
                            sb.insert(j, ')');
                            ++len;
                            break;
                        }
                    }

                }
            }
        }
        return sb.toString();
    }

    /**
     * 表达式计算
     * 先将中缀表达式转换为后缀表达式，再计算表达式的结果
     * @param expression 表达式
     * @return 运算结果
     * @throws NumberFormatException 数值非浮点型
     * @throwsInvalidExpressionException 表达式无效
     * @throwsUnknownOperatorException	未知的运算符
     */
    public static double operation(String expression)throws NumberFormatException,  UnknownOperatorException {

        // 预处理
        expression = expressionCompletion(expression);

        // 使用逆波兰算法处理
        LinkedList<String> rpnList = RPN.parse(expression);

        // 保存每一步运算结果的操作数栈
        Stack<Double> operands = new Stack<Double>();




        // 遍历逆波兰表达式中每一项元素
        for(String elem:rpnList){

            // 若是运算符
            if(RPN.isOperator(elem.charAt(0))){


                // 从操作数栈取出栈顶的两个操作数
                double value2 = operands.pop();
                double value1 = operands.pop();

                // 获得运算结果
                double result = binaryOperation(elem.charAt(0),value1,value2);

                // 将计算结果压栈
                operands.push(result);

                // 如果是数值
            }else{

                operands.push(Double.parseDouble(elem));
            }
        }

        // 返回操作数栈中唯一的元素
        return operands.pop();
    }

    /**
     * 二元运算
     * @param operator 运算符
     * @param value1 值1
     * @param value2 值2
     * @return 运算结果
     * @throwsUnknownOperatorException 传入未知的运算符
     */
    private static double binaryOperation(char operator, double value1, double value2) throws UnknownOperatorException{
        switch(operator){
            case '+':
                return value1+value2;
            case '-':
                return value1-value2;
            case '×':
                return value1*value2;
            case '÷':
                if(value2==0) throw new ArithmeticException("/ by zero.");
                return value1/value2;
            default:
                throw new UnknownOperatorException(operator);
        }
    }




}





