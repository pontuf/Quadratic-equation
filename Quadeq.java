import javax.swing.*;
import java.io.*;
import java.util.*;

public class Quadeq{
static String s[]=new String[2];
static int count;
public static String alg(int num, BufferedReader br,String ur[]) throws Exception{
	Random rand=new Random(num);
	double a=0,b,c,D,x1=0,x2=0;
	System.out.println("###Equation ¹"+num+"###");
	System.out.println("Enter first coefficient");
	while (a==0) a=rand.nextInt(11);
	System.out.println("Enter second coefficient");
	b=rand.nextInt(11);
	System.out.println("Enter third coefficient");
        c=rand.nextInt(11);
	s[0]="";
	s[0]=Double.toString(a)+"x^2";
	if (b>=0) s[0]=s[0]+"+";  
	s[0]=s[0]+Double.toString(b)+"x";
	if (c>=0) s[0]=s[0]+"+"; 
	s[0]=s[0]+Double.toString(c)+"=0";
	System.out.println(s[0]); 
	D=(b*b)-(4*a*c);
	if(D>=0){
	x1=(-b+Math.sqrt(D))/(2*a);
	x2=(-b-Math.sqrt(D))/(2*a);
	s[1]=String.format("%.2g%n",x1)+"; "+String.format("%.2g%n",x2);}
	if (D==0) s[1]=String.format("%.2g%n",x1); 
	if(D<0) { 
            D=(Math.sqrt(-D))/(2*a);
            x1=(-b)/(2*a);
            s[1]=String.format("%.2g%n",x1)+"+j"+String.format("%.2g%n",D)+
                    "; "+String.format("%.2g%n",x1)+"-j"+String.format("%.2g%n",D);
        }
	System.out.println("######");
	ur[num]=s[0];
	return s[1];
}
public static void main(String args[]) throws Exception{
	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the count of equations");
	s[0]=br.readLine();
	count=Integer.parseInt(s[0]);
	String res[]=new String[count+1];
	String ura[]=new String[count+1];
	for(int i=0;i<=count;i++){
		res[i]="0";
		ura[i]="0";}
	String ur[]=new String[count+1];
	for(int i=1;i<=count;i++){
		res[i]=alg(i,br,ur);}
	JFrame jf=new JFrame("Solution of quadratic equation");
	jf.setSize(jf.getMaximumSize());//(1280,768);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JTable jt=new JTable(count+1,2);
	jt.setVisible(true);
	jt.setBounds(1,1,600,16*(count+1));
	jt.setValueAt("Equation",0,0);
	jt.setValueAt("Solution",0,1);
	for(int i=1;i<=count;i++){
		jt.setValueAt(ur[i],i,0);	 
		jt.setValueAt(res[i],i,1);}	
        jt.setTableHeader(null);
        JScrollPane jsp=new JScrollPane(jt,
         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        jf.add(jsp);
	jf.setSize(jt.getPreferredScrollableViewportSize());
	jf.setVisible(true);
}
}
