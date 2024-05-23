# Attendance-Management
근태 관리 프로젝트

[인프런 워밍업 클럽 1기] BE 미니 프로젝트

 

본 게시글은 다음 강의 내용을 진행하고 있습니다.

자바와 스프링 부트로 생애 최초 서버 만들기, 누구나 쉽게 개발부터 배포까지! [서버 개발 올인원 패키지] - https://inf.run/XKQg

프로젝트 코드 깃허브 링크

Re-Note/Attendance-Management: 근태 관리 프로젝트 (github.com)

프로젝트 정의

프로젝트 코드

Team

package com.inhousecommutingsystem.inhousecommutingsystem.domain;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manager;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Employee> employees;

}

TeamController

package com.inhousecommutingsystem.controller;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
}

TeamService

package com.inhousecommutingsystem.service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}

TeamRepository

package com.inhousecommutingsystem.repository;

import com.inhousecommutingsystem.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

Employee

package com.inhousecommutingsystem.domain;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean isManager;
    private Date birthDate;
    private Date workStartDate;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}

EmployeeController

package com.inhousecommutingsystem.controller;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}

EmployeeService

package com.inhousecommutingsystem.service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

EmployeeRepository

package com.inhousecommutingsystem.repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

결과 사진

