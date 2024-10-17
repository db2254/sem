# USE CASE: 1 As an HR advisor I want to produce a report on the salary of employees in a department so that I can support financial reporting of the organisation.

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want to produce a report on the salary of employees in a department so that I can support financial reporting of the organisation.
### Scope

Company.

### Level

Primary task.

### Preconditions
1. The database contains current employee salary data
2. The department is known
### Success End Condition

A report with the salary data for all employees in the department is produced and provided to finance.
### Failed End Condition

No report is produced.
### Primary Actor

HR Advisor.

### Trigger

A request for financial information about a department’s salary data is sent to HR.
## MAIN SUCCESS SCENARIO

1. Finance requests salary information for a specific department.
2. HR advisor identifies the department for which salary data is needed.
3. HR advisor extracts current salary information for all employees within the specified department.
4. HR advisor generates a salary report.
5. HR advisor provides the salary report to finance.

## EXTENSIONS

1. *Department does not exist:*
   1. HR advisor informs finance that the department does not exist in the system.
2. *No employees in department:*
    1. HR advisor informs finance that there are no employees in the department.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
