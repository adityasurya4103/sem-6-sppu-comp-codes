rules = {
    "rule1": "If the employee meets all project deadlines, add 20 points to their score.",
    "rule2": "If the employee consistently exceeds expectations, add 30 points to their score.",
    "rule3": "If the employee shows initiative and takes on additional responsibilities, add 15 points to their score.",
    "rule4": "If the employee is frequently absent or misses deadlines, subtract 25 points from their score.",
    "rule5": "If the employee consistently performs below expectations, subtract 35 points from their score."
}

def evaluate_employee_performance(deadlines_met, expectations_exceeded, initiative_taken, absences, performance_below_expectations):
    score = 0
    if deadlines_met:
        score += 20
    if expectations_exceeded:
        score += 30
    if initiative_taken:
        score += 15
    if absences:
        score -= 25
    if performance_below_expectations:
        score -= 35
    return score

employee_data={}
n=int(input("Enter the number of data of employee you want to insert: "))
for i in range(0,n):
    name=input("Enter the name of the employee: ")
    data={
          "deadlines_met":bool(int(input("Enter the performance of deadlines met in terms of 0 or 1: "))),
          "expectations_exceeded": bool(int(input("Enter the performance of expectations exceeded in terms of 0 or 1: "))),
          "initiative_taken": bool(int(input("Enter the performance of initiative taken in terms of 0 or 1: "))),
          "absences": bool(int(input("Enter the performance of absences in terms of 0 or 1: "))),
          "performance_below_expectations":bool(int(input("Enter the performance of performance below expectations in terms  0 or 1: ")))
          }
    employee_data[name]=data
print("Rules for employee evaluation")
for rule in rules.values():
        print(f"- {rule}")
for name, data in employee_data.items():
    score = evaluate_employee_performance(data["deadlines_met"], data["expectations_exceeded"], data["initiative_taken"], data["absences"], data["performance_below_expectations"])
    print(f"Employee {name} scored {score} points")
   
