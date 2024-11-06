import java.util.Scanner;

public class 25_Activity {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        System.out.print("Enter Number of Processer: ");
        int P_N = Scan.nextInt();
        
        int[] P_ID = new int[P_N];
        int[] AT_ID = new int[P_N];
        int[] BT_ID = new int[P_N];
        int[] CT_ID = new int[P_N];
        int[] TAT_ID = new int[P_N];
        int[] WT_ID = new int[P_N];

        for (int i = 0; i < P_N; i++) {
            System.out.print("Enter the process " + (i + 1) + ". Arrival Time: ");
            AT_ID[i] = Scan.nextInt();
            System.out.print("Enter the process " + (i + 1) + ". Burst Time: ");        
            BT_ID[i] = Scan.nextInt();  
            P_ID[i] = i + 1;
        }

        // Sort processes by Arrival Time
        for (int i = 0; i < P_N; i++) {
            for (int j = i + 1; j < P_N; j++) {
                if (AT_ID[i] > AT_ID[j]) {
                    int Temp = AT_ID[i];
                    AT_ID[i] = AT_ID[j];
                    AT_ID[j] = Temp;

                    Temp = BT_ID[i];
                    BT_ID[i] = BT_ID[j];
                    BT_ID[j] = Temp;

                    Temp = P_ID[i];
                    P_ID[i] = P_ID[j];
                    P_ID[j] = Temp;
                } 
            }    
        }

        // Calculate Completion Time, Turnaround Time, and Waiting Time
        CT_ID[0] = AT_ID[0] + BT_ID[0];
        TAT_ID[0] = CT_ID[0] - AT_ID[0];
        WT_ID[0] = TAT_ID[0] - BT_ID[0];

        for (int i = 1; i < P_N; i++) {
            if (CT_ID[i - 1] < AT_ID[i]) {
                CT_ID[i] = AT_ID[i] + BT_ID[i];
            } else {
                CT_ID[i] = CT_ID[i - 1] + BT_ID[i];
            }

            TAT_ID[i] = CT_ID[i] - AT_ID[i];
            WT_ID[i] = TAT_ID[i] - BT_ID[i];
        } 

        // Print results
        System.out.println("P" + "\tAT" + "\tBT" + "\tCT" + "\tTAT" + "\tWT");
        for (int i = 0; i < P_N; i++) {
            System.out.println(P_ID[i] + "\t" + AT_ID[i] + "\t" + BT_ID[i] + "\t" + CT_ID[i] + "\t" + TAT_ID[i] + "\t" + WT_ID[i]);
        }

        // Print Gantt Chart
        System.out.print("Gantt Chart: ");
        for (int i = 0; i < P_N; i++) {
            System.out.print("P" + P_ID[i] + " ");
        }

        Scan.close();
    }
}
