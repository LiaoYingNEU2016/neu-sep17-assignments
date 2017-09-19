package assignment2;
class employeeSalary{
    public double employeeSalary( double hours){
        double salary;
        salary = 0;
        if (hours <= 36) {
            salary = hours * 15;
        }
        else if (hours >36 && hours<41){
            salary = 540 + (hours - 36) *15 * 1.5;
        }
        if (hours > 41) {
            salary = 652.5 + (hours - 41) * 15 *2;

        }return salary;
    }
    }
