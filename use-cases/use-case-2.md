# USE CASE: 2 As an HR advisor I want to produce a report on the salary of all employees so that I can support financial reporting of the organisation

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to produce a report on the salary of all employees so that I can support financial reporting of the organisation.
### Scope

Company.

### Level

Primary task.

### Preconditions
1. The database contains current salary data for all employees.
### Success End Condition

A report with the salary data for all employees in the department is produced and provided to finance.
### Failed End Condition

No report is produced.
### Primary Actor

HR Advisor.

### Trigger

A request for financial reporting data for all employees' salaries is sent to HR.
## MAIN SUCCESS SCENARIO

1. Finance requests salary information for all employees in the company.
2. HR advisor accesses the system to retrieve salary information for all employees.
3. HR advisor extracts current salary data for every employee in the organisation.
4. HR advisor generates the salary report.
5. HR advisor provides the salary report to finance.

## EXTENSIONS

1. *System or data access issues:*
   1. HR advisor is unable to retrieve the salary data due to a technical issue.
   2. HR advisor contacts IT for support or tries again once the issue is resolved.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
