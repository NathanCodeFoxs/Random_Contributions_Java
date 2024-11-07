import java.util.Scanner;

public class 26_Activity { 

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        System.out.print("Enter Number of Processes: ");
        int P_N = Scan.nextInt();

        int[] P_ID = new int[P_N];
        int[] AT_ID = new int[P_N];
        int[] BT_ID = new int[P_N];
        int[] CT_ID = new int[P_N];
        int[] TAT_ID = new int[P_N];
        int[] WT_ID = new int[P_N];
        boolean[] Process_Done = new boolean[P_N]; // To track completed processes

        for (int i = 0; i < P_N; i++) {
            System.out.print("Enter Process " + (i + 1) + " Arrival Time: ");
            AT_ID[i] = Scan.nextInt();
            System.out.print("Enter Process " + (i + 1) + " Burst Time: ");
            BT_ID[i] = Scan.nextInt();
            P_ID[i] = i + 1;
            Process_Done[i] = false; // Initially, no process is done
        }

        int Completed_Count = 0, Current_Time = 0;
        
        // While there are still processes to complete
        while (Completed_Count < P_N) {
            int Shortest_Index = -1;
            int Min_Burst_Time = Integer.MAX_VALUE;

            // Find the shortest job that has arrived
            for (int i = 0; i < P_N; i++) {
                if (!Process_Done[i] && AT_ID[i] <= Current_Time && BT_ID[i] < Min_Burst_Time) {
                    Min_Burst_Time = BT_ID[i];
                    Shortest_Index = i;
                }
            }

            // If a process is found to execute
            if (Shortest_Index != -1) {
                Current_Time += BT_ID[Shortest_Index];
                CT_ID[Shortest_Index] = Current_Time;
                TAT_ID[Shortest_Index] = CT_ID[Shortest_Index] - AT_ID[Shortest_Index];
                WT_ID[Shortest_Index] = TAT_ID[Shortest_Index] - BT_ID[Shortest_Index];
                Process_Done[Shortest_Index] = true;
                Completed_Count++;
            } else {
                // No process available, increment time
                Current_Time++;
            }
        }

        // Print results
        System.out.println("P" + "\tAT" + "\tBT" + "\tCT" + "\tTAT" + "\tWT");
        for (int i = 0; i < P_N; i++) {
            System.out.println(P_ID[i] + "\t" + AT_ID[i] + "\t" + BT_ID[i] + "\t" + CT_ID[i] + "\t" + TAT_ID[i] + "\t" + WT_ID[i]);
        }

        // Print Gantt Chart
        System.out.print("Gantt Chart: ");
        for (int i = 0; i < P_N; i++) {
            if (Process_Done[i]) {
                System.out.print("P" + P_ID[i] + " ");
            }
        }

        Scan.close();
    }
}
