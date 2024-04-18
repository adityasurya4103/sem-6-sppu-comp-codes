#include <iostream>
#include <vector>
#include <algorithm>

struct Job {
    int id;
    int deadline;
    int profit;
};

bool sortByProfit(const Job& job1, const Job& job2) {
    return job1.profit > job2.profit;
}

int scheduleJobs(std::vector<Job>& jobs) {
    std::sort(jobs.begin(), jobs.end(), sortByProfit);

    int maxDeadline = 0;
    for (const Job& job : jobs) {
        maxDeadline = std::max(maxDeadline, job.deadline);
    }

    std::vector<int> slots(maxDeadline, -1);
    std::vector<Job> scheduledJobs;
    int totalProfit = 0;

    for (const Job& job : jobs) {
        for (int slot = job.deadline - 1; slot >= 0; --slot) {
            if (slots[slot] == -1) {
                slots[slot] = job.id;
                scheduledJobs.push_back(job);
                totalProfit += job.profit;
                break;
            }
        }
    }

    std::cout << "Scheduled jobs: ";
    for (const Job& job : scheduledJobs) {
        std::cout << job.id << " ";
    }
    std::cout << std::endl;

    return totalProfit;
}

int main() {
	int n;
    std::cout << "Enter the number of jobs you want to enter: ";
    std::cin >> n;
    std::vector<Job> jobs(n);
    std::cout << "Enter the details of the jobs:\n";
    for (int i = 0; i < n; i++) {
        std::cout << "Job " << (i + 1) << ":\n";
        std::cout << "Enter the id of the job: ";
        std::cin >> jobs[i].id;
        std::cout << "Enter the deadline of the job: ";
        std::cin >> jobs[i].deadline;
        std::cout << "Enter the profit of the job: ";
        std::cin >> jobs[i].profit;
    }
	
    int totalProfit = scheduleJobs(jobs);
    std::cout << "Total profit: " << totalProfit << std::endl;

    return 0;
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