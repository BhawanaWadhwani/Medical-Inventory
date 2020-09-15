import java.util.*;
import java.io.*;

class Stock
{
    String productName;
    String productCode;
    int price;
    int numberOfItems;

    void getProductDetails()
    { 
        int total=price*numberOfItems;
        System.out.println("Product:"+productName+"\n"+"Code:"+productCode+"\n"+"Price:"+price+"Rs"+"\n"+"Number:"+numberOfItems+"\n"+"Total:"+total+"Rs"+"\n");
    }
    void beforeExit()throws IOException
    {
        File file=new File("/Users/bhawanajhalak/Desktop/oop/meds.txt");
        FileWriter fr2=new FileWriter(file,true);   
        int total=price*numberOfItems;
        fr2.write("Name : "+productName+"\n");
        fr2.write("Code : "+productCode+"\n");
        fr2.write("Number of Items : "+numberOfItems+"\n");
        fr2.write("Price : "+price+"Rs\n");
        fr2.write("Total : "+total+"Rs\n ");
        fr2.write("********************************************\n");
        fr2.flush();
        fr2.close();
    }
    void beforeExit2()throws IOException
    {
        File file2=new File("/Users/bhawanajhalak/Desktop/oop/surg.txt");
        FileWriter fr3=new FileWriter(file2,true);   
        int total = price*numberOfItems;
        fr3.write("Name : "+productName+"\n");
        fr3.write("Code : "+productCode+"\n");
        fr3.write("Number of Items : "+numberOfItems+"\n");
        fr3.write("Price : "+price+"Rs\n");
        fr3.write("Total : "+total+"Rs\n");
        fr3.write("********************************************\n");
        fr3.flush();
        fr3.close();
    }
    Stock(String productName,String productCode, int price, int numberOfItems)   //constructor 
    {
        super();
        this.productName= productName;
        this.productCode=productCode;
        this.price = price;
        this.numberOfItems = numberOfItems;
    }
}

class Proj
{
    public static void main(String args[])throws IOException
    {
        Stock[] medicine=new Stock[40];
        Stock[] surgical=new Stock[40];

        medicine[0]=new Stock("Cold Kit-3 Plus  10x1","CK",36,29);
        medicine[1]=new Stock("Azithral 500 mg  5x1","Az-500",93,38);
        medicine[2]=new Stock("Cetrizine 10mg 10x1","Ce-10",17,56);
        medicine[3]=new Stock("Oflox 200 mg  10x1","Of-200",55,20);
        medicine[4]=new Stock("Amlodac 5 mg  30x1","Am-5",65,27);
        medicine[5]=new Stock("Progynova 2 mg  28x1","Pr-2",360,15);

        surgical[0]=new Stock("Accu-Chek Instant S Blood Glucose Meter with 10 test strips","AC",846,19);
        surgical[1]=new Stock("One Touch Glucometer Verio Flex with 10 strips","OT",1400,13);
        surgical[2]=new Stock("Flamingo Lumbar Sacro Belt","FL",560,7);
        surgical[3]=new Stock("Dr Morepen Digital Thermometer","DT",120,17);

        boolean bo=true;
        boolean boo=false;
        int j=6;
        int q=4;
        int k,i,a,a2;

        Scanner scan=new Scanner(System.in);
        while(bo)
        {
            System.out.println("Enter M-Medicine and S-Surgical");
            String a1=scan.next();
            switch(a1)
            {
                case "M":case "m":
                System.out.println("Enter 1-Add New Medicine Stock \n 2-Add to Existing Medicine Stock \n 3-Remove from existing Medicine stock \n 4-View Medical stock \n 5-Print file and exit");
                a2=scan.nextInt();
                switch(a2)
                {
                    case 1:
                    System.out.println("Enter name and code");
                    String med1=scan.next();
                    String code1=scan.next(); 
                    int pri1,quantity1;
                    boolean success = false;
                    while (!success) 
                    {
                        try 
                        {
                            System.out.print("Enter price and quantity: ");
                            pri1 = scan.nextInt();
                               //System.out.print("Enter quantity: ");
                            quantity1 = scan.nextInt();
                            medicine[j]=new Stock(med1,code1,pri1,quantity1);
                            ++j;
                              // System.out.println("You entered " + num);
                            success = true;
                        } catch (InputMismatchException e) 
                        {
                         scan.next();
                         System.out.println("You have entered invalid data. Enter some details again");
                     }
                 }
                 break;
                 case 2:
                 System.out.println("Enter code and quantity added");
                 String code2=scan.next();
                 int quantity2=scan.nextInt();
                 boolean success5=true;
                 for(k=0; k<j; k++)
                 {
                    if(medicine[k].productCode.equals(code2))
                    {
                        a=medicine[k].numberOfItems+quantity2;
                        medicine[k].numberOfItems=a;
                        success5=false;
                    }
                }
                if(success5)
                {
                    System.out.println("Product Code not found");
                }
                break;
                case 3:
                System.out.println("Enter code and quantity sold");
                String code3=scan.next();
                int quantity3=scan.nextInt();
                boolean success3=true;

                for(k=0; k<j; k++)
                {
                    if(medicine[k].productCode.equals(code3))
                    {
                        if(medicine[k].numberOfItems<quantity3)
                        {
                            System.out.println("Stock underflow");
                        }
                        else
                        {
                            medicine[k].numberOfItems=medicine[k].numberOfItems-quantity3;
                        }
                        success3 = false;
                        break;
                    }
                }
                if(success3) 
                {

                    System.out.println("Product Code not found");
                }
                break;
                case 4:
                for(k=0;k<j;k++)
                {    
                    medicine[k].getProductDetails();
                }
                break;
                case 5:
                for(k=0;k<j;k++)
                {    
                    medicine[k].beforeExit();
                }
                File file=new File("/Users/bhawanajhalak/Desktop/oop/meds.txt");
                FileReader fr=new FileReader(file);  
                int z;    
                while((z=fr.read())!=-1)    
                    System.out.print((char)z);
                fr.close();
                bo=false;
                return;
                default:
                System.out.println("Enter valid input");
            }
            break;
            case "S":case "s":
            System.out.println("1-Add New Surgical Stock \n 2-Add to Existing Surgical Stock \n 3-Remove from Existing Surgical Stock \n 4-View surgical stock \n 5-Print file and exit");
            a2=scan.nextInt();
            switch(a2)
            {
                case 1:
                System.out.println("Enter name and code");
                String sur4=scan.next();
                String code4=scan.next();
                boolean success1=false;
                int pri4,quantity4;
                while(!success1)
                {
                    try
                    {
                        System.out.println("Enter price and quantity: ");
                        pri4=scan.nextInt();
//System.out.println("Enter quantity");
                        quantity4=scan.nextInt();
                        surgical[q]=new Stock(sur4,code4,pri4,quantity4);
                        ++q;
                        success1=true;
                    }
                    catch(InputMismatchException e)
                    {
                        scan.next();
                        System.out.println("You have entered invalid data. Enter some details again");
                    }
                }
                break;
                case 2:
                System.out.println("Enter code and quantity added");
                String code5=scan.next();
                int quantity5=scan.nextInt();
                boolean success6=true;
                for(k=0; k<q; k++)
                {
                    if(surgical[k].productCode.equals(code5))
                    {
                        surgical[k].numberOfItems=surgical[k].numberOfItems+quantity5;
                        success6=false;
//System.out.println("Product Code not found");
                    }
//System.out.println("Product Code not found");
                }
                if(success6)
                {
                    System.out.println("Product Code not found");
                }
                break;
                case 3:
                System.out.println("Enter code and quantity sold");
                String code6=scan.next();
                int quantity6=scan.nextInt();
                boolean success4=true;
                for(k=0; k<q; k++)
                {
                    if(surgical[k].productCode.equals(code6))
                    {
                        if(quantity6<=surgical[k].numberOfItems)
                            surgical[k].numberOfItems=surgical[k].numberOfItems-quantity6;
                        else
                        {
                            System.out.println("Stock Underflow");
                            success4=false;
                        }
                    }
                }
                if(success4)
                {
                    System.out.println("Product Code not found");
                }
                break;
                case 4:
                for(k=0;k<q;k++)
                {
                    surgical[k].getProductDetails();
                }
                break;
                case 5:
                for(k=0;k<q;k++)
                {    
                    surgical[k].beforeExit2();
                }
                File file2=new File("/Users/bhawanajhalak/Desktop/oop/surg.txt");
                FileReader fr4=new FileReader(file2);  
                int z;    
                while((z=fr4.read())!=-1)    
                    System.out.print((char)z);
                fr4.close();
                bo=false;
                return;
                default:    
                System.out.println("Enter valid input");
            }
            break;
            default:
            System.out.println("Enter valid input");
        }

    }
}
}