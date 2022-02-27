import java.util.*;
class shareDetails{
    int buyshare()// Buying of Shares
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of shares want to buy :");
        int buy=sc.nextInt();
        return buy;
    }
    String buydate()//Buying date of shares
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date of buying shares :");
        String date=sc.next();
        return date;
    }
    int sellshare()//Selling of shares
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of shares want to sell :");
        int sell =sc.nextInt();
        return sell;
    }
    String selldate()//Selling date of shares
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date of selling shares :");
        String date=sc.next();
        return date;
    }
     int[] transaction(int n)//Stores the transaction id
    {
        Random rnd = new Random(); 
        int i;
        int[] arr =new int[n];
        for(i=0;i<n;i++)
        {
            arr[i] = rnd.nextInt(999999);;
        }
        return arr;
    }
    int[] dividend(int n,int[] BankBal)// Stores devidend of the share holders
    {
        int i;
        int[] arr =new int[n];
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("_____________________DEVIDEND DETAILS_____________________");
        for(i=0;i<n;i++)
        {
            System.out.println("SHARE HOLDER "+(i+1));
            System.out.println("Enter the devidend :");
            arr[i]=sc.nextInt();
        }
        return arr;
    }    
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of share holders");
        int n = s.nextInt();
        String[] name = new String[n];//storing name of share holders
        int[] BankAcc = new int[n];//storing bank account details of share holders
        int[] BankBal = new int[n];//Assuming bank balance before having any shares
        String[] buyDate = new String[n];//storing buying shares date of share holders
        String[] sellDate = new String[n];//storing sellind shares date of share holders
        int[] CurrShare = new int[n];//storing shares of share holders
        int[] transaction = new int[n];//storing the transiction ids
        int[] buyShare = new int[n];//storing shares bought of share holders
        int[] sellShare = new int[n];//stroing shares selled by share holders
        int[] devidend = new int[n];//storing devidends of share holders
        int[] UpdatedShare = new int[n];//storing updated shares of share holders
        int i;
        System.out.println();
        System.out.println("_____________________USER DETAILS_____________________");
        for(i=0;i<n;i++)
        {
            System.out.println("SHARE HOLDER "+(i+1));
            System.out.println("Enter the name :");
            name[i] = s.next();
            System.out.println("Enter the Bank Account :");
            BankAcc[i] = s.nextInt();
            System.out.println("Enter the Account Balance :");
            BankBal[i] = s.nextInt();
            System.out.println("Enter the current shares :");
            CurrShare[i] = s.nextInt();
        }
        for(i=0;i<n;i++)
        {
            UpdatedShare[i] = CurrShare[i];
        }
        shareDetails ob = new shareDetails();
        transaction =ob.transaction(n);
        devidend=ob.dividend(n,BankBal);
        for(i=0;i<n;i++)
        {
            BankBal[i] = BankBal[i]+(BankBal[i]*devidend[i]);
        }
        System.out.println();
        System.out.println("_____________________BUYING OF SHARES_____________________");
        for (i=0;i<n;i++)
        {
            System.out.println("SHARE HOLDER "+(i+1));
            buyShare[i] = ob.buyshare();
            buyDate[i] = ob.buydate();
            BankBal[i] = BankBal[i] +(buyShare[i]*1000);//we assume that 1 share value is 1000 rupees 
            UpdatedShare[i] = UpdatedShare[i]+buyShare[i];
        }
        System.out.println();
        System.out.println("_____________________SELLING OF SHARES_____________________");
        for (i=0;i<n;i++)
        {
            System.out.println("SHARE HOLDER "+(i+1));
            sellShare[i] = ob.sellshare();
            sellDate[i] = ob.selldate();
            BankBal[i] = BankBal[i] -(sellShare[i]*1000);//we assume that 1 share value is 1000 rupees
            UpdatedShare[i] = UpdatedShare[i]-sellShare[i];
        }
        //Printing the output in the tabular format
        System.out.println("Share holder name \tBank Acc No \tMy Shares \tBuy_Date \tShare Buy \ttransactionid \tSell_Date \tShare Sell  \ttransactionid \tUpdated Share \tDividend  \tAcc Bal");
        for(i=0;i<n;i++)
        {
            System.out.println(name[i]+" \t\t\t"+BankAcc[i]+ "\t\t"+CurrShare[i]+" \t\t"+buyDate[i]+"\t"+buyShare[i]+" \t\t"+transaction[i]+" \t\t"+sellDate[i]+"      "+sellShare[i]+" \t\t"+transaction[i]+" \t\t"+UpdatedShare[i]+" \t\t"+devidend[i]+" \t\t"+BankBal[i]);
            System.out.println();
        }
    }
}