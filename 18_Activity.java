import java.util.Scanner;

class Process {
    int processId, arrivalTime, burstTime, completionTime, turnaroundTime, waitingTime;

    Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class 18_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter the number of Processes: ");
        int numProcesses = scanner.nextInt();
        Process[] processes = new Process[numProcesses];

        // Input arrival and burst times for each process
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter process " + (i + 1) + " Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Enter process " + (i + 1) + " Burst Time: ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        // Sort processes by Arrival Time
        for (int i = 0; i < numProcesses - 1; i++) {
            for (int j = 0; j < numProcesses - i - 1; j++) {
                if (processes[j].arrivalTime > processes[j + 1].arrivalTime) {
                    Process temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }

        // Calculate Completion, Turnaround, and Waiting Times
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            currentTime += p.burstTime;
        }

        // Display results in tabular format
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.println("P" + p.processId + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }

        // Display Gantt Chart
        System.out.print("\nGantt Chart: ");
        for (Process p : processes) {
            System.out.print("P" + p.processId + " ");
        }
        System.out.println();

        scanner.close();
    }
}
