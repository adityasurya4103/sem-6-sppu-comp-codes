import java.util.*;

class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobScheduling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the no of Job you want to enter: ");
        int n=in.nextInt();
        Job[] jobs =new Job[n];
        System.out.print("Enter the details of the Job: \n");
        for(int i=0;i<n;i++){
            System.out.println("Job "+(i+1)+" :");
            System.out.print("Enter the id of Job: ");
            int id=in.nextInt();
            System.out.print("Enter the deadline of Job: ");
            int deadline=in.nextInt();
            System.out.print("Enter the profit of Job: ");
            int profit=in.nextInt();
            jobs[i]=new Job(id, deadline, profit);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slots = new int[maxDeadline + 1];

        int totalProfit = 0;
        for (Job job : jobs) {
          
            for (int i = job.deadline; i > 0; i--) {
                if (slots[i] == 0) {
                    slots[i] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.print("Scheduled Jobs: ");
        for (int i = 1; i < slots.length; i++) {
            if (slots[i] != 0) {
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}

/*
Enter the no of Job you want to enter: 5  
Enter the details of the Job:
Job 1 :
Enter the id of Job: 1
Enter the deadline of Job: 2  
Enter the profit of Job: 100
Job 2 :
Enter the id of Job: 2
Enter the deadline of Job: 1  
Enter the profit of Job: 19
Job 3 :
Enter the id of Job: 3
Enter the deadline of Job: 2  
Enter the profit of Job: 27
Job 4 :
Enter the id of Job: 4
Enter the deadline of Job: 1  
Enter the profit of Job: 25
Job 5 :
Enter the id of Job: 5
Enter the deadline of Job: 3
Enter the profit of Job: 15  
Scheduled Jobs: 3 1 5
Total Profit: 142 
*/