package com.lr.concurrent05;

/**
 * @author liurui
 * @date 2020/12/30 5:40 下午
 */
public class student2 {

    public static void main(String[] args) {

        student1[] s=new student1[20];
        for(int i=0;i<20;i++) {
            s[i] = new student1();
            s[i].number = i+1;
            s[i].state =(int)(Math.random()*(6-1+1)+1);
            s[i].score = (int)(Math.random()*(100-0+1));
            System.out.println(s[i].info());
        }


        }

    public void print(student1[] s) {
        for(int i=0;i < s.length;i++) {
            System.out.println("ÅÅÐòºó£º ");
            System.out.println(s[i].info());
        }
    }


    /**
     *
     * @param s
     */
    public void sort(student1[] s) {
        for(int i=0;i<s.length-1;i++) {
            for(int j=0;j<s.length-1-i;j++) {
                if(s[j].score>s[j+1].score) {
                    student1 temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;

                }
            }
        }

    }
}
class student1{
    int number,state,score;
    //ÏÔÊ¾Ñ§ÉúÐÅÏ¢µÄ·½·¨
    public String info(){
        return "Ñ§ºÅ£º " + number + "Äê¼¶£º " + state + "³É¼¨£º "+ score;
    }
}
