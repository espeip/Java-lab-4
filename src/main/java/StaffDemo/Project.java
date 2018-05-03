package StaffDemo;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private ArrayList<Employee> employee;
    private TeamLeader teamLeader;
    private ProjectManager projectManager;
    private String name;
    private double budget;

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
        employee = new ArrayList<Employee>();
    }

    double allotMoney(double money) {
        try {
            if (budget >= money) {
                budget -= money;
                return money;
            } else throw new StaffException("not enough money");
        } catch (StaffException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public double getBudget() {
        return budget;
    }

    public void addEmployee(Employee employee) {
        if(employee.getClass().getSimpleName().equals("ProjectManager"))
            setProjectManager((ProjectManager)employee);
        else if (employee.getClass().getSimpleName().equals("TeamLeader"))
            setTeamLeader((TeamLeader)employee);
        else this.employee.add(employee);
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        teamLeader.setProject(this);
        this.teamLeader = teamLeader;
    }

    public void setProjectManager(ProjectManager projectManager) {
        projectManager.setProject(this);
        this.projectManager = projectManager;
    }

    public void addManagers(List<Manager> managers) {
        this.employee.addAll(managers);
    }

    public void addProgrammers(List<Programmer> programmers) {
        this.employee.addAll(programmers);
    }

    public void addTesters(List<Tester> testers) {
        this.employee.addAll(testers);
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
    }
}
