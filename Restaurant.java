import java.io.*;
class Restaurant
{
    //final double cabAc=100,cabNonac=50;
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    String [] item = {"Tea", "Coffee","Cookie", "Pie", "Pastry", "Candy",  
        "Roll", "Noodle", "Pizza", "Burger", "Momo","Samosa", "Nihari",
        "Soup", "Dosa","Idli", "Soda", "Gelato", "Chapati","Pakoda"};
    double []price = {10.00, 15.00, 30.00, 100.00, 50.00,20.00,40.00,35.00,
        80.00,50.00,40.00,10.00,45.00,30.00,35.00,30.00,35.00,100.00,20.00,15.00};
    int []selectedItems;
    int []selectedPlates;
    double subTot = 0;
    void disp()throws IOException
    {
        while(true)
        {
            System.out.println("**************");
            System.out.println("**  WELCOME TO SPA RESTAURANT  ***");
            System.out.println("*** Memari Bazar, Burdwan ****");
            System.out.println("**************");
            System.out.println("Available Items:-");
            
            int len =item.length;
            System.out.println("Sl No.\tItem Name \t Price");
            System.out.println("--------------------------------");
            for(int i=0; i<len; i++)
            {
                System.out.println((i+1)+"\t"+item[i]+ "\t|\t" +price[i]);
                System.out.println("--------------------------------");
            }
            System.out.println("Enter How many items do you want to order:");
            int no= Integer.parseInt(br.readLine());
            selectedItems = new int[no];
            selectedPlates = new int[no];
            for(int j=1; j<=no; j++)
            {
                System.out.print("Enter SL No. of item-"+j+ " : ");
                int sl = Integer.parseInt(br.readLine());
                selectedItems[j-1] = sl-1;
                System.out.print("\nEnter how many plates of "+item[sl-1]
                                        + " do you want to order : ");
                int PNo=Integer.parseInt(br.readLine());
                selectedPlates[j-1] = PNo;
            }
            
            //Billing part
            System.out.println("\n ***** GENERATING BILL ***"
                                                            + "****");            
            System.out.println("Item Name \t Plates \t Price ");
            System.out.println("----------------------------------------"
                                                            + "------");
            for(int i=0; i<no; i++)
            {
                int itemIndex = selectedItems[i];
                subTot += price[itemIndex]*selectedPlates[i];
                System.out.println(item[itemIndex]+"\t\t  "+selectedPlates[i]
                                + "\t|\t  " +price[itemIndex]*selectedPlates[i]);
                System.out.println("--------------------------------------"
                                                + "------------------------");
            }
            System.out.println("Sub Total"+"\t\t\t  "+ subTot);
            double vat = subTot*4/100;
            System.out.println("VAT @4%  "+"\t\t\t  "+ vat);
            subTot += vat;
            System.out.println("------------------------------------------"
                                                    + "--------------------");
            System.out.println("Total    "+"\t\t\t  "+ subTot);
            System.out.print("** Do you want to make another bill(Y/N):");
            String choice = br.readLine();
            if(choice.equalsIgnoreCase("y"))
                continue;
            else
                System.out.println("THANK YOU FOR USING COMPUTER BILLING SYSTEM");
                System.out.println("****PLEASE VISIT AGAIN*****");
                System.out.println("******HAVE A GOOD DAY****");                
                return;
            
        }
    }
}
