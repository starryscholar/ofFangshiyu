package cn.edu.usts.game;

/**
 * Created by 11616 on 2020/4/2.
 */

public class Judger {


    int getPVCResult(int value1,int value2,Person person,Computer computer){

        int i =value1-value2;
        if(i==2||i==-1) {
            person.setScore(person.getScore()+1);
            return 1;//person win
        }
        else if(i==1||i==-2) {
            computer.setScore(computer.getScore()+1);
            return 2;//computer win
        }
        else {

            return  0;//all win
        }
    }
    int getPVPResult(int value1,int value2,Person person1,Person person2){

        int i =value1-value2;
        if(i==2||i==-1) {
            person1.setScore(person1.getScore()+1);
            return 1;//person1 win
        }
        else if(i==1||i==-2) {
            person2.setScore(person2.getScore()+1);
            return 2;//person2 win
        }
        else {

            return  0;//all win
        }
    }

}
