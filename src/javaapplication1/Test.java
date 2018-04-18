/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Test {
 
      public static void main(String args[]) {

ArrayList al1=new ArrayList();
al1.add("sample1");
al1.add("file1");          
al1.add("job1");
al1.add("method1");
al1.add("tune1");          
al1.add("operator1");

ArrayList al2=new ArrayList();
al2.add("sample2");
al2.add("file2");          
al2.add("job2");
al2.add("method2");
al2.add("tune2");          
al2.add("operator2");

ArrayList al3=new ArrayList();
al3.add("sample3");
al3.add("file3");          
al3.add("job3");
al3.add("method3");
al3.add("tune3");          
al3.add("operator3");

ArrayList all=new ArrayList();
all.add(al1);
all.add(al2);
all.add(al3);
//ArrayList[] aList=new ArrayList{al1,al2,al3)};
ArrayList finalList=new ArrayList();
for(int i=0;i<al1.size();i++)
{
String line="";
for(int j=0;j<all.size();j++)
{
    ArrayList al=(ArrayList)all.get(j);
    line+=","+al.get(i);
}
System.out.println(line);
}

System.exit(0);
       
    }
      
}
