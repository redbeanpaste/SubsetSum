package subsetsum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SubsetSum 
{
    public int count = 0;
    
    void solve(int[] d, int sum)
    {
        int m = 0, n = d.length;
        int[] x = {};
        ArrayDeque q = new ArrayDeque(2*n);
        q.add(x);
        System.out.println("Set of "+Arrays.toString(d));
        
        while(!q.isEmpty())
        {
            x = (int[]) q.poll(); m = x.length;
            int s = sum(d,x); 
            /*
            System.out.println("-------------------------\npoll "+Arrays.toString(x));
            System.out.println("sum "+s);
            */
            if(s > sum) {}
            else
            {
                if(m == n) 
                {
                    if(s == sum)
                    {
                        count += 1;
                        print(d,x);
                    }
                }
                else
                {
                    
                    int[] x0 = Arrays.copyOf(x, m+1);
                    int[] x1 = Arrays.copyOf(x, m+1);
                    x0[m] = 0; x1[m] = 1;
                    m += 1;
                    /*
                    System.out.println("x0 "+Arrays.toString(x0));
                    System.out.println("s0 "+s0);
                    System.out.println("x1 "+Arrays.toString(x1));
                    System.out.println("s1 "+s1+"\n-------------------------");
                    */
                    q.add(x0);
                    q.add(x1);
                }
            }
        }
        System.out.println("for sum = "+sum);
    }
    
    int sum(int[] d, int[] x)
    {
        int sum = 0;
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] == 1) sum += d[i];
        }
            return sum;
    }
    
    void print(int[] d,int[] x)
    {
        String s = "";
        System.out.print("Subset "+count+" : [");
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] == 1) s = s.concat(String.valueOf(d[i])+",");
        }
        if(s.endsWith(",")) s = s.substring(0,s.length()-1);
        System.out.println(s+"]");
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line = br.readLine();
        String[] read = line.split(" ");
        int[] d = new int[read.length];
        for(int i = 0; i < d.length; i++)
            d[i] = Integer.parseInt(read[i]);
        int sum = Integer.parseInt(br.readLine());
        
        SubsetSum s = new SubsetSum();
        s.solve(d, sum);
        
    }
    
}
